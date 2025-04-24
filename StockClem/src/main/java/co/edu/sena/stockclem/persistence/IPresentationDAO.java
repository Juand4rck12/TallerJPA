package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Presentation;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Juan Diego
 * Objetivo: inteface para DAO de presentation
 */
public interface IPresentationDAO {
    public void insert(Presentation presentation) throws Exception;
    public void update(Presentation presentation) throws Exception;
    public void delete(Presentation presentation) throws Exception;
    public Presentation findById(Long id) throws Exception;
    public List<Presentation> findAll() throws Exception;
}
