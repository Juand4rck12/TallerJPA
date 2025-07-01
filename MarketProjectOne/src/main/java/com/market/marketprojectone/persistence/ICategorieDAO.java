package com.market.marketprojectone.persistence;

import com.market.marketprojectone.model.Categories;
import java.util.List;

/**
 *
 * @author victus
 */
public interface ICategorieDAO {
    public void insert(Categories categories) throws Exception;
    public void update(Categories categories) throws Exception;
    public void delete(Categories categories) throws Exception;
    public Categories findById(Long id) throws Exception;
    public Categories findByName(String name) throws Exception;
    public List<Categories> findAll() throws Exception;
}
