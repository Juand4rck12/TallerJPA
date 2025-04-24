package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Supplier;
import java.util.List;

/**
 * date : 24/04/2025
 * @author Esteban Colorado Vargas
 */
public class SupplierDAO implements ISupplierDAO {

    @Override
    public void insert(Supplier supplier) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(supplier);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Supplier supplier) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(supplier);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Supplier supplier) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(supplier);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Supplier findById(long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Supplier.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().createNamedQuery("Supplier.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
