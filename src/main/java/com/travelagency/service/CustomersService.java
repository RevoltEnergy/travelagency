package com.travelagency.service;

import com.travelagency.dao.CustomersDAO;
import com.travelagency.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ace on 07/07/2017.
 */
@Service
public class CustomersService {

    private CustomersDAO customersDAO;

    @Autowired
    public void setCustomersDAO(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    public void addCustomer(CustomerEntity customer) {
        customersDAO.addEntity(customer);
    }

    public void updateCustomer(CustomerEntity customer) {
        customersDAO.updateEntity(customer);
    }

    public CustomerEntity getCustomerById(Integer customerId) {
        return customersDAO.getEntityByID(customerId);
    }

    public List<CustomerEntity> getCustomersByColumnNameAndValue(String columnName, Object value) {
        return customersDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    public List<CustomerEntity> getAllCustomers() {
        return customersDAO.getAllEntities();
    }

    public void deleteCustomer(CustomerEntity customer) {
        customersDAO.deleteEntity(customer);
    }
}
