package co.edu.sena.stockclem.persistence;

import co.edu.sena.stockclem.model.Person;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public class PersonDAO implements IPersonDAO{

    @Override
    public void insert(Person person) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(person);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Person person) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(person);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Person person) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(person);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Person findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Person.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().createNamedQuery("Person.findAll").getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
