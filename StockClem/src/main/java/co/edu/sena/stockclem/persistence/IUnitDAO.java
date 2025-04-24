package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Unit;
import java.util.List;

/**
 * Fecha: 24/04/2025
 * @author Juan Diego
 * Objetivo: inteface para DAO de unit
 */
public interface IUnitDAO {
    public void insert(Unit unit) throws Exception;
    public void update(Unit unit) throws Exception;
    public void delete(Unit unit) throws Exception;
    public Unit findById(Long id) throws Exception;
    public List<Unit> findAll() throws Exception;
}
