package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.Suppliers;
import java.util.List;

/**
 *
 * @author victus
 */
public interface ISupplierDAO {
    public void insert(Suppliers suppliers) throws Exception;
    public void update(Suppliers suppliers) throws Exception;
    public void delete(Suppliers suppliers) throws Exception;
    public Suppliers findById (Long id) throws Exception;
    public List<Suppliers> findAll() throws Exception;
}
