package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Entry;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public class EntryDAO implements IEntryDAO{

    @Override
    public void insert(Entry entry) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(entry);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Entry entry) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(entry);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Entry entry) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(entry);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Entry findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Entry.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Entry> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().createNamedQuery("Entry.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
