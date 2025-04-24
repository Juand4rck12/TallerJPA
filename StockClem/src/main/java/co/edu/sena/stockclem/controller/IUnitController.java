package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Unit;
import java.util.List;

/**
 * date 24/04/2025
 * @author Juan Diego
 */
public interface IUnitController {
    public void insert(Unit unit) throws Exception;
    public void update(Unit unit) throws Exception;
    public void delete(Long id) throws Exception;
    public Unit findById(Long id) throws Exception;
    public List<Unit> findAll() throws Exception;
}
