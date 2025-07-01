package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.Categories;
import java.util.List;

/**
 *
 * @author victus
 */
public class CategorieDAO implements ICategorieDAO {

    @Override
    public void insert(Categories categories) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(categories);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Categories categories) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(categories);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Categories categories) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(categories);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Categories findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Categories.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Categories findByName(String name) throws Exception {
        try {
            List<Categories> results = EntityManagerHelper.getEntityManager()
                    .createNamedQuery("Categories.findByName", Categories.class)
                    .setParameter("name", name)
                    .getResultList();
            
            return results.isEmpty() ? null : results.get(0);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Categories> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().
                    createNamedQuery("Categories.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }

}
