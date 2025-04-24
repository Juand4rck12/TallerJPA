package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Category;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Juan Diego
 * Objetivo: inteface para DAO de category
 */
public interface ICategoryDAO {
    public void insert(Category category) throws Exception;
    public void update(Category category) throws Exception;
    public void delete(Category category) throws Exception;
    public Category findById(Long id) throws Exception;
    public List<Category> findAll() throws Exception;
}
