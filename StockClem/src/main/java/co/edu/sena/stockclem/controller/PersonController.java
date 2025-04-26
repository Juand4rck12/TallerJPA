package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Person;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 */
public class PersonController implements IPersonController{

    @Override
    public void insert(Person person) throws Exception {
        if(person == null) {
            throw new Exception("La persona es obligatoria...");
        }
        if(person.getDocument() == null) {
            throw new Exception("El documento es obligatorio...");
        }
        if(person.getDocument() == 0) {
            throw new Exception("El documento no puede ser 0...");
        }
        if ("".equals(person.getName())) {
            throw new Exception("El nombre es obligatorio...");
        }
        
        // INSERTAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersonDAO().insert(person);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Person person) throws Exception {
        if(person.getDocument() == null) {
            throw new Exception("El documento es obligatorio...");
        }
        if(person.getDocument() == 0) {
            throw new Exception("El documento no puede ser 0...");
        }
        if ("".equals(person.getName())) {
            throw new Exception("El nombre es obligatorio...");
        }
        
        Person personExits = DAOFactory.getPersonDAO().findById(person.getDocument());
        if (personExits == null) {
            throw new Exception("La persona no existe...");
        }
        // ACTUALIZAR
        personExits.setDocument(person.getDocument());
        personExits.setName(person.getName());
        personExits.setPhone(person.getPhone());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersonDAO().update(person);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long document) throws Exception {
        if (document == 0) {
            throw new Exception("El documento es obligatorio para eliminarlo...");
        }
        Person personExits = DAOFactory.getPersonDAO().findById(document);
        if (personExits == null) {
            throw new Exception("No existe el articulo...");
        }
        
        // ELIMINAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersonDAO().delete(personExits);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Person findById(Long document) throws Exception {
        if (document == 0) {
            throw new Exception("el documento es obligatorio...");
        }
        return DAOFactory.getPersonDAO().findById(document);
    }

    @Override
    public List<Person> findAll() throws Exception {
        return DAOFactory.getPersonDAO().findAll();
    }
    
}
