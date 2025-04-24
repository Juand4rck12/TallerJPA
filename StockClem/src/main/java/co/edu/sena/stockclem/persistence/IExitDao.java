package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Exit;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Juan Diego
 * Objetivo: inteface para DAO de exit
 */
public interface IExitDao {
    public void insert(Exit exit) throws Exception;
    public void update(Exit exit) throws Exception;
    public void delete(Exit exit) throws Exception;
    public Exit findById (Long id) throws Exception;
    public List<Exit> findAll() throws Exception;
}
