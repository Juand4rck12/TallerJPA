package com.market.marketprojectone.controller;

import com.market.marketprojectone.model.Categories;
import java.util.List;

/**
 *
 * @author victus
 */
public interface ICategorieController {
    public void insert(Categories categories) throws Exception;
    public void update(Categories categories) throws Exception;
    public void delete(Long id) throws Exception;
    public Categories findByid(Long id) throws Exception;
    public List<Categories> findAll() throws Exception;
}
