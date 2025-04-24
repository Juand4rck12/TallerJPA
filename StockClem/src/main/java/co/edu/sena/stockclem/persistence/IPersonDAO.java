package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Person;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public interface IPersonDAO {
    public void insert(Person person) throws Exception;
    public void update(Person person) throws Exception;
    public void delete(Person person) throws Exception;
    public Person findById(Long id) throws Exception;
    public List<Person> findAll() throws Exception;
}
