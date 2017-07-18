package com.travelagency.service;

import com.travelagency.dao.OrdersDAO;
import com.travelagency.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ace on 07/07/2017.
 */
@Service
public class OrdersService {

    private OrdersDAO ordersDAO;

    @Autowired
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public void addOrder(OrderEntity order) {
        ordersDAO.addEntity(order);
    }

    public void updateOrder(OrderEntity order) {
        ordersDAO.updateEntity(order);
    }

    public OrderEntity getCustomerById(Integer orderId) {
        return ordersDAO.getEntityByID(orderId);
    }

    public List<OrderEntity> getOrdersByColumnNameAndValue(String columnName, Object value) {
        return ordersDAO.getEntitiesByColumnNameAndValue(columnName, value);
    }

    public List<OrderEntity> getAllOrders() {
        return ordersDAO.getAllEntities();
    }

    public void deleteOrder(OrderEntity order) {
        ordersDAO.deleteEntity(order);
    }
}
