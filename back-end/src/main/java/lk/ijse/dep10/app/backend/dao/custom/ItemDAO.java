package lk.ijse.dep10.app.backend.dao.custom;

import lk.ijse.dep10.app.backend.dao.CrudDAO;
import lk.ijse.dep10.app.backend.entity.Item;

import java.util.List;

public interface ItemDAO extends CrudDAO<Item, String> {
    List<Item> findItems(String query) throws Exception;
}
