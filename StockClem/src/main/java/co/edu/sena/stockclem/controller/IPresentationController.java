package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Presentation;
import java.util.List;

/**
 * date 24/04/2025
 * @author Juan Diego
 */
public interface IPresentationController {
    public void insert(Presentation presentation) throws Exception;
    public void update(Presentation presentation) throws Exception;
    public void delete(Long id) throws Exception;
    public Presentation findById(Long id) throws Exception;
    public List<Presentation> findAll() throws Exception;
}
