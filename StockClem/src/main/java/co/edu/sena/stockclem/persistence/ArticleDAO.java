package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Article;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public class ArticleDAO implements IArticleDAO{

    @Override
    public void insert(Article article) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(article);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Article article) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(article);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Article article) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(article);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Article findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Article.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Article> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().createNamedQuery("Article.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
