package com.market.marketprojectone.controller;

import com.market.marketprojectone.model.Categories;
import com.market.marketprojectone.persistence.DAOFactory;
import com.market.marketprojectone.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author victus
 */
public class CategorieController implements ICategorieController {

    // Validaciones generales de categoria
    private void validateCategory(Categories category, Boolean isNew) throws Exception {
        if (category == null) {
            throw new Exception("La categoria es obligatoria");
        }
        String name = category.getName();
        if (name == null || name.isBlank()) {
            throw new Exception("El nombre es obligatorio");
        }
        if (name.length() > 100) {
            throw new Exception("El nombre debe tener menos de 100 caracteres");
        }

        // VALIDACIÓN DE UNICIDAD MEJORADA
        Categories existingCategory = DAOFactory.getCategorieDAO().findByName(name);

        if (existingCategory != null) {
            throw new Exception("Ya existe una categoria con ese nombre");

        }
    }

    // Validaciones de existencia
    private void validateExists(Long id) throws Exception {
        if (id == null) {
            throw new Exception("El id es obligatorio");
        }
        Categories found = DAOFactory.getCategorieDAO().findById(id);
        if (found == null) {
            throw new Exception("No existe una categoria con el id: " + id);
        }
    }

    @Override
    public void insert(Categories categories) throws Exception {
        validateCategory(categories, true);
        EntityManagerHelper.beginTransaction();

        try {
            DAOFactory.getCategorieDAO().insert(categories);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollBack();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(Categories category) throws Exception {
        EntityManagerHelper.beginTransaction();
        validateCategory(category, false);
        validateExists(category.getId());
        
        try {
            DAOFactory.getCategorieDAO().update(category);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollBack();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
//        // 1) Validaciones de negocio (unicidad, FK, etc.)
//        validateCategory(caregory, false);
//
//        EntityManagerHelper.beginTransaction();
//        try {
//            DAOFactory.getCategorieDAO().update(caregory);
//            EntityManagerHelper.commit();
//        } catch (ConstraintViolationException cve) {
//            EntityManagerHelper. // Agrupa todos los mensajes de violación en un solo String
//                    String allMessages = cve.getConstraintViolations().stream()
//                            .map(ConstraintViolation::getMessage)
//                            .collect(Collectors.joining("\n"));
//            throw new BusinessException(allMessages);
//        } catch (Exception ex) {
//            EntityManagerHelper.rollback();
//            throw new BusinessException("Error interno al actualizar: " + ex.getMessage());
//        } finally {
//            EntityManagerHelper.closeEntityManager();
//        }
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == null) {
            throw new Exception("El id es obligatorio");
        }

        Categories categorieExists = DAOFactory.getCategorieDAO().findById(id);
        if (categorieExists == null) {
            throw new Exception("No existe una categoria con ese id");
        }

        // Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategorieDAO().delete(categorieExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Categories findByid(Long id) throws Exception {
        if (id == null) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getCategorieDAO().findById(id);
    }

    @Override
    public List<Categories> findAll() throws Exception {
        return DAOFactory.getCategorieDAO().findAll();
    }

}
