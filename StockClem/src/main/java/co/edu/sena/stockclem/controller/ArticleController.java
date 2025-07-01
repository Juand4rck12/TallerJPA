package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Article;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

public class ArticleController implements IArticleController {
    
    
    // —————————————————————————————————————————————
    // Métodos auxiliares privados para centralizar validaciones
    // —————————————————————————————————————————————

    /**
     * Valida los campos de negocio de Article.
     * @param article Objeto a validar
     * @param isNew   true para insert, false para update
     * @throws Exception si alguna regla falla
     */
    private void validateArticle(Article article, boolean isNew) throws Exception {
        if (article == null) {
            throw new Exception("El artículo es obligatorio.");
        }
        if (article.getName() == null || article.getName().isBlank()) {
            throw new Exception("El nombre del artículo es obligatorio.");
        }
        if (article.getQuantity() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0.");
        }
        if (article.getIdPresentation() == null) {
            throw new Exception("La presentación es obligatoria.");
        }
        if (article.getIdCategory() == null) {
            throw new Exception("La categoría es obligatoria.");
        }
        if (article.getIdSupplier() == null) {
            throw new Exception("El proveedor es obligatorio.");
        }
        if (isNew && article.getIdArticle() != null) {
            Article exists = DAOFactory.getArticleDAO().findById(article.getIdArticle());
            if (exists != null) {
                throw new Exception("Ya existe un artículo con ese ID.");
            }
        }
    }

    /**
     * Verifica que exista un Article con el ID dado.
     * @param id Identificador del artículo
     * @throws Exception si id es null/0 o no se encuentra el artículo
     */
    private void validateExists(Long id) throws Exception {
        if (id == null || id == 0) {
            throw new Exception("El ID del artículo es obligatorio.");
        }
        Article found = DAOFactory.getArticleDAO().findById(id);
        if (found == null) {
            throw new Exception("No existe un artículo con ID " + id + ".");
        }
    }

    @Override
    public void insert(Article article) throws Exception {
        // 1) Validaciones de negocio
        validateArticle(article, true);

        // 2) Transacción y persistencia
        EntityManagerHelper.beginTransaction();
        try {
            DAOFactory.getArticleDAO().insert(article);
            EntityManagerHelper.commit();
        } catch (Exception ex) {
            EntityManagerHelper.rollback();
            throw new Exception("Error al insertar artículo: " + ex.getMessage(), ex);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(Article article) throws Exception {
        // 1) Validaciones de negocio
        validateArticle(article, false);
        validateExists(article.getIdArticle());

        // 2) Transacción y merge
        EntityManagerHelper.beginTransaction();
        try {
            // opción: merge directo de 'article'
            DAOFactory.getArticleDAO().update(article);
            EntityManagerHelper.commit();
        } catch (Exception ex) {
            EntityManagerHelper.rollback();
            throw new Exception("Error al actualizar artículo: " + ex.getMessage(), ex);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        // 1) Validar existencia
        validateExists(id);

        // 2) Transacción y eliminación
        EntityManagerHelper.beginTransaction();
        try {
            Article toDelete = DAOFactory.getArticleDAO().findById(id);
            DAOFactory.getArticleDAO().delete(toDelete);
            EntityManagerHelper.commit();
        } catch (Exception ex) {
            EntityManagerHelper.rollback();
            throw new Exception("Error al eliminar artículo: " + ex.getMessage(), ex);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public Article findById(Long id) throws Exception {
        validateExists(id);
        return DAOFactory.getArticleDAO().findById(id);
    }

    @Override
    public List<Article> findAll() throws Exception {
        return DAOFactory.getArticleDAO().findAll();
    }

}
