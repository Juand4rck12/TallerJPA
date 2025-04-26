package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Entry;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date: 24/04/2025
 * @author Esteban Colorado Vargas
 * objetivo: crear los controladores para Article
 */
public class EntryController implements IEntryController{

    @Override
    public void insert(Entry entry) throws Exception {
        if (entry == null) {
            throw new Exception("El articulo es obligatorio...");
        }
        if ("".equals(entry.getSenaCode())) {
            throw new Exception("El codigo SENA es obligatorio...");
        }
        if (entry.getDate() == null) {
            throw new Exception("La fecha es obligatoria...");
        }
        if (entry.getExpirationDate() == null) {
            throw new Exception("La fecha de vencimiento es obligatoria...");
        }
        if (entry.getQuantity() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0...");
        }
        //FK
        if (entry.getIdArticle() == null) {
            throw new Exception("El id del articulo es obligatorio...");
        }
        //
        Entry entryExits = DAOFactory.getEntryDAO().findById(entry.getIdEntry());
        if (entryExits != null) {
            throw new Exception("Ya existe una entrada con ese id...");
        }
        //INSERTAR
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEntryDAO().insert(entry);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Entry entry) throws Exception {
        if (entry == null) {
                throw new Exception("La entrada es obligatorio...");
        }
        if ("".equals(entry.getSenaCode())) {
            throw new Exception("El codigo SENA es obligatorio...");
        }
        if (entry.getDate() == null) {
            throw new Exception("La fecha es obligatoria...");
        }
        if (entry.getExpirationDate() == null) {
            throw new Exception("La fecha de vencimiento es obligatoria...");
        }
        if (entry.getQuantity() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0...");
        }
        //FK
        if (entry.getIdArticle() == null) {
            throw new Exception("El id del articulo es obligatorio...");
        }
        //
        Entry entryExits = DAOFactory.getEntryDAO().findById(entry.getIdEntry());
        if (entryExits == null) {
            throw new Exception("No existe una entrada con ese id...");
        }
        // ACTUALIZAR
        entryExits.setSenaCode(entry.getSenaCode());
        entryExits.setDate(entry.getDate());
        entryExits.setExpirationDate(entry.getExpirationDate());
        entryExits.setQuantity(entry.getQuantity());
        entryExits.setSenaCode(entry.getSenaCode());
        entryExits.setObservations(entry.getObservations());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEntryDAO().update(entry);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id de la entrada es obligatorio para eliminarla...");
        }
        Entry entryExits = DAOFactory.getEntryDAO().findById(id);
        if (entryExits == null) {
            throw new Exception("No existe la entrada...");
        }
    }

    @Override
    public Entry findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("el documento es obligatorio...");
        }
        return DAOFactory.getEntryDAO().findById(id);
    }

    @Override
    public List<Entry> findAll() throws Exception {
        return DAOFactory.getEntryDAO().findAll();
    }
    
}
