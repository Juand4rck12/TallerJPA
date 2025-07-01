package com.market.marketprojectone.controller;

import com.market.marketprojectone.model.Products;
import java.util.List;

/**
 *
 * @author victus
 */
public interface IProductController {
    public void insert(Products products) throws Exception;
    public void update(Products products) throws Exception;
    public void delete(Long id) throws Exception;
    public Products findById(Long id) throws Exception;
    public List<Products> findAll() throws Exception;
}
