package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Supplier;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public class SupplierController implements ISupplierController{

    @Override
    public void insert(Supplier supplier) throws Exception {
        if(supplier == null) {
            throw new Exception("El proovedor es obligatorio...");
        }
        if ("".equals(supplier.getName())) {
            throw new Exception("El nombre del proovedor es obligatorio...");
        }
        if ("".equals(supplier.getPhone())) {
            throw new Exception("El numero del proovedor es obligatorio...");
        }
        
        //INSERTAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierDAO().insert(supplier);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Supplier supplier) throws Exception {
        if(supplier == null) {
            throw new Exception("El proovedor es obligatorio...");
        }
        if (supplier.getIdUnit() == null) {
            throw new Exception("El id es obligatorio...") ;
        }
        if ("".equals(supplier.getName())) {
            throw new Exception("El nombre del proovedor es obligatorio...");
        }
        if ("".equals(supplier.getPhone())) {
            throw new Exception("El numero del proovedor es obligatorio...");
        }
        
        Supplier supplierExits = DAOFactory.getSupplierDAO().findById(supplier.getIdUnit());
        if (supplierExits == null) {
            throw new Exception("El proovedor no existe...");
        }
        // ACTUALIZAR
        supplierExits.setName(supplier.getName());
        supplierExits.setPhone(supplier.getPhone());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierDAO().update(supplier);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
         if (id == 0) {
            throw new Exception("El id es obligatorio para eliminarlo...");
        }
        Supplier supplierExits = DAOFactory.getSupplierDAO().findById(id);
        if (supplierExits == null) {
            throw new Exception("No existe el proovedor...");
        }
    }

    @Override
    public Supplier findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("el id es obligatorio...");
        }
        return DAOFactory.getSupplierDAO().findById(id);
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        return DAOFactory.getSupplierDAO().findAll();
    }
    
}
