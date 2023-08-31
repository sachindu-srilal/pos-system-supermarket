package lk.ijse.dep10.app.backend.dao.custom;

import lk.ijse.dep10.app.backend.dao.CrudDAO;
import lk.ijse.dep10.app.backend.entity.OrderCustomer;

public interface OrderCustomerDAO extends CrudDAO<OrderCustomer, Integer> {
    boolean existsOrderByCustomerId(int customerId) throws Exception;
}
