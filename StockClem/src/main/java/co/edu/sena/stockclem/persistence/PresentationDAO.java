package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Presentation;
import java.util.List;
import javax.persistence.Query;

/**
 * Fecha:24/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: implementar DAO para modelo de Presentation
 */
public class PresentationDAO implements IPresentationDAO {

    @Override
    public void insert(Presentation presentation) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(presentation);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Presentation presentation) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(presentation);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Presentation presentation) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(presentation);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Presentation findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Presentation.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Presentation> findAll() throws Exception {
        try {
            String name = "Presentation.findAll";
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(name);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
