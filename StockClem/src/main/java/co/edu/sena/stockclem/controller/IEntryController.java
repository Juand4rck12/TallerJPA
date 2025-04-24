package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Entry;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface IEntryController {
    public void insert(Entry entry) throws Exception;
    public void update(Entry entry) throws Exception;
    public void delete(Entry entry) throws Exception;
    public Entry findById(long id) throws Exception;
    public List<Entry> findAll() throws Exception;
}
