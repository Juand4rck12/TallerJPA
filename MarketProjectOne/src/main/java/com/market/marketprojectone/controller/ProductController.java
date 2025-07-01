package com.market.marketprojectone.controller;

import com.market.marketprojectone.model.Products;
import com.market.marketprojectone.persistence.DAOFactory;
import java.util.List;

/**
 *
 * @author victus
 */
public class ProductController implements IProductController {

    @Override
    public void insert(Products products) throws Exception {
    }

    @Override
    public void update(Products products) throws Exception {
    }

    @Override
    public void delete(Long id) throws Exception {
    }

    @Override
    public Products findById(Long id) throws Exception {
        
    }

    @Override
    public List<Products> findAll() throws Exception {
        try {
            return DAOFactory.getProductDAO().findAll();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
