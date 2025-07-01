package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.OrderItems;
import com.market.marketprojectone.model.OrderItemsPK;
import java.util.List;

/**
 *
 * @author victus
 */
public class OrderItemsDAO implements IOrderItemsDAO {

    @Override
    public void insert(OrderItems orderItems) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(orderItems);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(OrderItems orderItems) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(orderItems);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(OrderItems orderItems) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(orderItems);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public OrderItems findById(OrderItemsPK id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(OrderItems.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<OrderItems> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().
                    createNamedQuery("OrderItems.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
