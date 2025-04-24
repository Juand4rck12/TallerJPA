package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Supplier;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface ISupplierDAO {
    public void insert(Supplier supplier) throws Exception;
    public void update(Supplier supplier) throws Exception;
    public void delete(Supplier supplier) throws Exception;
    public Supplier findById(long id) throws Exception;
    public List<Supplier> findAll() throws Exception;
}
