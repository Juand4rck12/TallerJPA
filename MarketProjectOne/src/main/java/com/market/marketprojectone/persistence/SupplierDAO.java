package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.Suppliers;
import java.util.List;

/**
 *
 * @author victus
 */
public class SupplierDAO implements ISupplierDAO {

    @Override
    public void insert(Suppliers suppliers) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(suppliers);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Suppliers suppliers) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(suppliers);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Suppliers suppliers) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(suppliers);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Suppliers findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Suppliers.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Suppliers> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().
                    createNamedQuery("Suppliers.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
