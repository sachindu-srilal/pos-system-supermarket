package lk.ijse.dep10.app.backend.dao.custom.impl;


import lk.ijse.dep10.app.backend.dao.custom.QueryDAO;
import lk.ijse.dep10.app.backend.dto.OrderDTO2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static lk.ijse.dep10.app.backend.dao.util.Mappers.ORDER_DTO_2_ROW_MAPPER;
@Repository
public class QueryDAOImpl implements QueryDAO {

    private final JdbcTemplate jdbcTemplate;

    public QueryDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<OrderDTO2> findOrdersByQuery(String query) throws Exception {
        String sql = "SELECT CONCAT('OD', LPAD(o.id, 3, 0))          as id, " +
                "       o.datetime, " +
                "       CONCAT('C', LPAD(oc.customer_id, 3, 0)) as customer_id, " +
                "       c.name, " +
                "       SUM(od.qty * od.unit_price)             as total " +
                "FROM `order` o " +
                "         LEFT OUTER JOIN order_customer oc ON o.id = oc.order_id " +
                "         LEFT OUTER JOIN customer c ON oc.customer_id = c.id " +
                "         INNER JOIN order_detail od ON o.id = od.order_id " +
                "WHERE CONCAT('OD', LPAD(o.id, 3, 0)) LIKE ? " +
                "   OR o.datetime LIKE ? " +
                "   OR CONCAT('C', LPAD(oc.customer_id, 3, 0)) LIKE ? " +
                "   OR c.name LIKE ? " +
                "GROUP BY o.id;";
        query = "%" + query + "%";
        return jdbcTemplate.query(sql, ORDER_DTO_2_ROW_MAPPER,query,query,query,query)
                .stream().peek(o -> {
                    if (o.getCustomerName() == null) o.setCustomerId(null);
                }).collect(Collectors.toList());
    }
}
