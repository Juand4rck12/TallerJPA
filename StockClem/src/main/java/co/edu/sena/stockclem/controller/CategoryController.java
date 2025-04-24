package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Category;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date :24/04/2025
 * @author Juan Diego
 * objetivo: crear los controladores para Category
 */
public class CategoryController implements ICategoryController {

    @Override
    public void insert(Category category) throws Exception {
        if (category == null) {
            throw new Exception("La categoria no puede ser nula");
        }
        
        if ("".equals(category.getName())) {
            throw new Exception("El nombre de la categoria no puede ser vacio");
        }
        
        // Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().insert(category);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Category category) throws Exception {
        if (category == null) {
            throw new Exception("La categoria no puede ser nula");
        }
        
        if ("".equals(category.getName())) {
            throw new Exception("El nombre de la categoria no puede ser vacio");
        }
        
        Category categoryExists = DAOFactory.getCategoryDAO().findById(category.getIdCategory());
        if (categoryExists == null) {
            throw new Exception("No existe una categoria con ese Id");
        }
        
        // Actualizar
        categoryExists.setName(categoryExists.getName());
        categoryExists.setDescription(categoryExists.getDescription());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().update(category);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        
        Category categoryExists = DAOFactory.getCategoryDAO().findById(id);
        if (categoryExists == null) {
            throw new Exception("No existe una categoria con ese id");
        }
        
        // Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategoryDAO().delete(categoryExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Category findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        
        return DAOFactory.getCategoryDAO().findById(id);
    }

    @Override
    public List<Category> findAll() throws Exception {
        return DAOFactory.getCategoryDAO().findAll();
    }
    
}
