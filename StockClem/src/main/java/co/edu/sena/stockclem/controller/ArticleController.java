package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Article;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date :24/04/2025
 * @author Esteban Colorado Vargas 
 * objetivo: crear los controladores para Article
 */
public class ArticleController implements IArticleController {

    @Override
    public void insert(Article article) throws Exception {
        if (article == null) {
            throw new Exception("El articulo es obligatorio...");
        }
        if ("".equals(article.getName())) {
            throw new Exception("El nombre del articulo es obligatorio...");
        }
        if (article.getQuantity() <= 0) {
            throw new Exception("La cantidad no puede ser 0...");
        }
        //FKS
        if (article.getIdPresentation() == null) {
            throw new Exception("El id de la presentacion es obligatorio...");
        }
        if (article.getIdCategory() == null) {
            throw new Exception("El id de categoria es obligatorio...");
        }
        if (article.getIdSupplier() == null) {
            throw new Exception("El id del proovedor es obligatorio...");
        }
        //
        Article articleExits = DAOFactory.getArticleDAO().findById(article.getIdArticle());
        if (articleExits != null) {
            throw new Exception("Ya existe un articulo con ese id...");
        }
        //INSERTAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticleDAO().insert(article);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Article article) throws Exception {
        if (article == null) {
            throw new Exception("El articulo es obligatorio...");
        }
        if ("".equals(article.getName())) {
            throw new Exception("El nombre del articulo es obligatorio...");
        }
        if (article.getQuantity() < 0) {
            throw new Exception("La cantidad no puede ser inferior a 0...");
        }
        //FKS
        if (article.getIdPresentation() == null) {
            throw new Exception("El id de la presentacion es obligatorio...");
        }
        if (article.getIdCategory() == null) {
            throw new Exception("El id de categoria es obligatorio...");
        }
        if (article.getIdSupplier() == null) {
            throw new Exception("El id del proovedor es obligatorio...");
        }
        //
        Article articleExits = DAOFactory.getArticleDAO().findById(article.getIdArticle());
        if (articleExits == null) {
            throw new Exception("No existe el articulo...");
        }
        // ACTUALIZAR
        articleExits.setName(article.getName());
        articleExits.setQuantity(article.getQuantity());
        articleExits.setPhoto(article.getPhoto());
        articleExits.setTechnicalSheet(article.getTechnicalSheet());
        articleExits.setIdPresentation(article.getIdPresentation());
        articleExits.setIdCategory(article.getIdCategory());
        articleExits.setIdSupplier(article.getIdSupplier());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticleDAO().update(article);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id del articulo es obligatorio para eliminarlo...");
        }
        Article articleExits = DAOFactory.getArticleDAO().findById(id);
        if (articleExits == null) {
            throw new Exception("No existe el articulo...");
        }
        
        // ELIMINAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticleDAO().delete(articleExits);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Article findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("el documento es obligatorio...");
        }
        return DAOFactory.getArticleDAO().findById(id);
    }

    @Override
    public List<Article> findAll() throws Exception {
        return DAOFactory.getArticleDAO().findAll();
    }
}
