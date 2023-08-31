package lk.ijse.dep10.app.backend.dao.custom;

import lk.ijse.dep10.app.backend.dto.OrderDTO2;

import java.util.List;

public interface QueryDAO {
    List<OrderDTO2> findOrdersByQuery(String query) throws Exception;
}
