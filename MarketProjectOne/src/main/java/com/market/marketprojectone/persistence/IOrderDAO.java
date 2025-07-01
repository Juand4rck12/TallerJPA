package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.Orders;
import java.util.List;

/**
 *
 * @author victus
 */
public interface IOrderDAO {
    public void insert(Orders orders) throws Exception;
    public void update(Orders orders) throws Exception;
    public void delete(Orders orders) throws Exception;
    public Orders findByid (Long id) throws Exception;
    public List<Orders> findAll() throws Exception;
}
