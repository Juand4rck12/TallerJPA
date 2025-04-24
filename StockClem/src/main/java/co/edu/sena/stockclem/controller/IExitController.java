package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Exit;
import java.util.List;

/**
 * date 24/04/2025
 * @author Juan Diego
 */
public interface IExitController {
    public void insert(Exit exit) throws Exception;
    public void update(Exit exit) throws Exception;
    public void delete(Long id) throws Exception;
    public Exit findById (Long id) throws Exception;
    public List<Exit> findAll() throws Exception;
}
