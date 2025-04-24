package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Unit;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date :24/04/2025
 * @author Juan Diego
 * objetivo: crear los controladores para Unit
 */
public class UnitController implements IUnitController {

    @Override
    public void insert(Unit unit) throws Exception {
        if (unit == null) {
            throw new Exception("La unidad es obligatoria");
        }
        
        // Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().insert(unit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Unit unit) throws Exception {
        if (unit == null) {
            throw new Exception("La unidad es obligatoria");
        }
        
        Unit unitExists = DAOFactory.getUnitDAO().findById(unit.getIdUnit());
        if (unitExists == null) {
            throw new Exception("No existe una unidad con ese id");
        }
        
        // Actualizar
        unitExists.setName(unitExists.getName());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().update(unit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        
        Unit unitExists = DAOFactory.getUnitDAO().findById(id);
        if (unitExists == null) {
            throw new Exception("No existe una unidad con ese id");
        }
        
        // Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitDAO().delete(unitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Unit findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        
        return DAOFactory.getUnitDAO().findById(id);
    }

    @Override
    public List<Unit> findAll() throws Exception {
        return DAOFactory.getUnitDAO().findAll();
    }
    
}
