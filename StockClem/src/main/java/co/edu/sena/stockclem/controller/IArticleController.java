package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Article;
import java.util.List;

/**
 * date: 24/0472025
 * @author Esteban Colorado Vargas
 */
public interface IArticleController {
    public void insert(Article article) throws Exception;
    public void update(Article article) throws Exception;
    public void delete(Long id) throws Exception;
    public Article findById(Long id) throws Exception;
    public List<Article> findAll() throws Exception;
}
