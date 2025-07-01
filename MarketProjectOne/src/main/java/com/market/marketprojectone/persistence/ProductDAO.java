package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.Products;
import java.util.List;

/**
 *
 * @author victus
 */
public class ProductDAO implements IProductDAO {

    @Override
    public void insert(Products products) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(products);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Products products) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(products);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Products products) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(products);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Products findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Products.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Products> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().
                    createNamedQuery("Products.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
