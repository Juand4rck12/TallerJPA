package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Category;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Juan Diego
 */
public interface ICategoryController {
    public void insert(Category category) throws Exception;
    public void update(Category category) throws Exception;
    public void delete(Long id) throws Exception;
    public Category findById(Long id) throws Exception;
    public List<Category> findAll() throws Exception;
}
