package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Exit;
import java.util.List;
import javax.persistence.Query;

/**
 * Fecha:24/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: implementar DAO para modelo de Exit
 */
public class ExitDAO implements IExitDao {

    @Override
    public void insert(Exit exit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(exit);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Exit exit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(exit);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Exit exit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(exit);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Exit findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Exit.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Exit> findAll() throws Exception {
        try {
            String name = "Exit.findAll";
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(name);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
