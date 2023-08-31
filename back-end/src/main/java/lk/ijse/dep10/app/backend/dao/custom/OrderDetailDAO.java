package lk.ijse.dep10.app.backend.dao.custom;

import lk.ijse.dep10.app.backend.dao.CrudDAO;
import lk.ijse.dep10.app.backend.entity.OrderDetail;
import lk.ijse.dep10.app.backend.entity.OrderDetailPK;

public interface OrderDetailDAO extends CrudDAO<OrderDetail, OrderDetailPK> {
    boolean existsOrderDetailByItemCode(String itemCode) throws Exception;
}
