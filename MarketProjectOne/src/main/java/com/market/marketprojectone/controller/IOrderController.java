package com.market.marketprojectone.controller;

import com.market.marketprojectone.model.Orders;
import java.util.List;

/**
 *
 * @author victus
 */
public interface IOrderController {
    public void insert(Orders orders) throws Exception;
    public void update(Orders orders) throws Exception;
    public void delete(Long id) throws Exception;
    public Orders findById(Long id) throws Exception;
    public List<Orders> findAll() throws Exception;
}
