package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Supplier;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface ISupplierController {
    public void insert(Supplier supplier) throws Exception;
    public void update(Supplier supplier) throws Exception;
    public void delete(Long id) throws Exception;
    public Supplier findById(Long id) throws Exception;
    public List<Supplier> findAll() throws Exception;
}
