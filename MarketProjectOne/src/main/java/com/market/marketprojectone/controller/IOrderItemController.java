package com.market.marketprojectone.controller;

import com.market.marketprojectone.model.OrderItems;
import java.util.List;

/**
 *
 * @author victus
 */
public interface IOrderItemController {
    public void insert(OrderItems orderItems) throws Exception;
    public void update(OrderItems orderItems) throws Exception;
    public void delete(Long id) throws Exception;
    public OrderItems findById(Long id) throws Exception;
    public List<OrderItems> findAll() throws Exception;
}
