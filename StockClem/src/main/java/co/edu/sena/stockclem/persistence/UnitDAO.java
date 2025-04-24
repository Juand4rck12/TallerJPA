package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Unit;
import java.util.List;
import javax.persistence.Query;

/**
 * Fecha:24/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: implementar DAO para modelo de Unit
 */
public class UnitDAO implements IUnitDAO {

    @Override
    public void insert(Unit unit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(unit);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Unit unit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(unit);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Unit unit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(unit);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Unit findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Unit.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Unit> findAll() throws Exception {
        try {
            String name = "Unit.findAll";
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(name);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
