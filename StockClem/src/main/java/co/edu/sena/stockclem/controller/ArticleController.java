package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Article;
import java.util.List;

/**
 * date :24/04/2025
 * @author Esteban Colorado Vargas
 * objetivo: crear los controladores para Article
 */
public class ArticleController implements IArticleController{

    @Override
    public void insert(Article article) throws Exception {
        if(article == null ) {
            throw new Exception("El articulo es obligatorio...");
        }
        if(article.getName() == null) {
            throw new Exception("El nombre del articulo es obligatorio...");
        }
        if(article.getQuantity() == 0) {
            throw new Exception("La cantidad no puede ser 0...");
        }
        
        //INSERTAR
        
    }

    @Override
    public void update(Article article) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Article article) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Article findById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Article> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
