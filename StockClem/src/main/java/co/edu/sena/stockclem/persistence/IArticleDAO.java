package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Article;
import java.util.List;

/**
 * date 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface IArticleDAO {
    public void insert(Article article) throws Exception;
    public void update(Article article) throws Exception;
    public void delete(Article article) throws Exception;
    public Article findById(Long id) throws Exception;
    public List<Article> findAll() throws Exception;
}
