package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.OrderItems;
import com.market.marketprojectone.model.OrderItemsPK;
import java.util.List;

/**
 *
 * @author victus
 */
public interface IOrderItemsDAO {
    public void insert(OrderItems orderItems) throws Exception;
    public void update(OrderItems orderItems) throws Exception;
    public void delete(OrderItems orderItems) throws Exception;
    public OrderItems findById(OrderItemsPK id) throws Exception;
    public List<OrderItems> findAll() throws Exception;
}
