package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Person;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface IPersonController {
    public void insert(Person person) throws Exception;
    public void update(Person person) throws Exception;
    public void delete(Long document) throws Exception;
    public Person findById(Long document) throws Exception;
    public List<Person> findAll() throws Exception;
}
