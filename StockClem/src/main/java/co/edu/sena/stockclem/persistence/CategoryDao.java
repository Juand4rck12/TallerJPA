package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Category;
import java.util.List;
import javax.persistence.Query;

/**
 * Fecha:24/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: implementar DAO para modelo de Category
 */
public class CategoryDao implements ICategoryDAO {

    @Override
    public void insert(Category category) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(category);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Category category) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(category);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Category category) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(category);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Category findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Category.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Category> findAll() throws Exception {
        try {
            String name = "Category.findAll";
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(name);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
