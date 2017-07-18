package com.travelagency.dao;

import com.travelagency.entity.OrderEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by ace on 07/06/2017.
 */
@Repository
public class OrdersDAO extends EntityDAOImpl<OrderEntity> {
    public OrdersDAO() {
    }
}
