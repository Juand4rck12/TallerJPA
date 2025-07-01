package com.market.marketprojectone.controller;

import com.market.marketprojectone.model.Suppliers;
import java.util.List;

/**
 *
 * @author victus
 */
public interface ISupplierController {
    public void insert(Suppliers suppliers) throws Exception;
    public void update(Suppliers suppliers) throws Exception;
    public void delete(Long id) throws Exception;
    public Suppliers findById(Long Id) throws Exception;
    public List<Suppliers> findAll() throws Exception;
}
