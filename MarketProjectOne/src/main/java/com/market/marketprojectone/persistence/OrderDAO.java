package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.Orders;
import java.util.List;

/**
 *
 * @author victus
 */
public class OrderDAO implements IOrderDAO {

    @Override
    public void insert(Orders orders) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(orders);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Orders orders) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(orders);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Orders orders) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(orders);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Orders findByid(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Orders.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Orders> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().
                    createNamedQuery("Orders.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
