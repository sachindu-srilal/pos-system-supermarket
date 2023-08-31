package lk.ijse.dep10.app.backend.dao.custom.impl;

import lk.ijse.dep10.app.backend.dao.custom.CustomerDAO;
import lk.ijse.dep10.app.backend.entity.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static lk.ijse.dep10.app.backend.dao.util.Mappers.CUSTOMER_ROW_MAPPER;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final JdbcTemplate jdbcTemplate;

    public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() throws Exception {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer", Long.class);
    }

    @Override
    public Customer save(Customer customer) throws Exception {
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement stm=con.prepareStatement("INSERT INTO customer (name, address, contact) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, customer.getName());
            stm.setString(2, customer.getAddress());
            stm.setString(3, customer.getContact());
            return stm;
        },keyHolder);
        customer.setId(keyHolder.getKey().intValue());
        return customer;
    }

    @Override
    public void update(Customer entity) throws Exception {

    }

    @Override
    public void deleteById(Integer pk) throws Exception {

    }

    @Override
    public Optional<Customer> findById(Integer pk) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return null;
    }

    @Override
    public boolean existsById(Integer pk) throws Exception {
        return false;
    }

    @Override
    public List<Customer> findCustomers(String query) throws Exception {
        return null;
    }

    @Override
    public Optional<Customer> findCustomerByIdOrContact(String idOrContact) throws Exception {
        return Optional.empty();
    }

    @Override
    public boolean existsCustomerByContact(String contact) throws Exception {
        return CustomerDAO.super.existsCustomerByContact(contact);
    }

    @Override
    public boolean existsCustomerByContactAndNotId(String contact, Integer id) throws Exception {
        return false;
    }
}
