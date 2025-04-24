package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Exit;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date :24/04/2025
 * @author Juan Diego
 * objetivo: crear los controladores para Exit
 */
public class ExitController implements IExitController {

    @Override
    public void insert(Exit exit) throws Exception {
        if (exit == null) {
            throw new Exception("La salida es obligatoria");
        }
        
        if (exit.getDate() == null) {
            throw new Exception("La fecha es obligatoria");
        }
        
        if (exit.getQuantity() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        
        if (exit.getIdArticle() == null) {
            throw new Exception("El id del articulo es obligatorio");
        }
        
        // Si el documento es nulo o cero
        if (exit.getDocument() == null || exit.getDocument().getDocument() == 0) {
            throw new Exception("El documento es obligatorio y no puede ser 0");
        }
        
        if (exit.getIdUnit() == null) {
            throw new Exception("El id de unidad es obligatorio");
        }
        
        // Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitDao().insert(exit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Exit exit) throws Exception {
        if (exit == null) {
            throw new Exception("La salida es obligatoria");
        }
        
        if (exit.getDate() == null) {
            throw new Exception("La fecha es obligatoria");
        }
        
        if (exit.getQuantity() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        
        if (exit.getIdArticle() == null) {
            throw new Exception("El id del articulo es obligatorio");
        }
        
        // Si el documento es nulo o cero
        if (exit.getDocument() == null || exit.getDocument().getDocument() == 0) {
            throw new Exception("El documento es obligatorio y no puede ser 0");
        }
        
        if (exit.getIdUnit() == null) {
            throw new Exception("El id de unidad es obligatorio");
        }
        
        Exit exitExits = DAOFactory.getExitDao().findById(exit.getIdExit());
        if (exitExits == null) {
            throw new Exception("No existe una salida con ese id");
        }
        
        // Actualizar
        exitExits.setDate(exitExits.getDate());
        exitExits.setQuantity(exitExits.getQuantity());
        exitExits.setObservations(exitExits.getObservations());
        exitExits.setIdArticle(exitExits.getIdArticle());
        exitExits.setDocument(exitExits.getDocument());
        exitExits.setIdUnit(exitExits.getIdUnit());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitDao().update(exit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == null) {
            throw new Exception("El id es obligatorio");
        }
        
        Exit exitExits = DAOFactory.getExitDao().findById(id);
        if (exitExits == null) {
            throw new Exception("No existe una salida con ese id");
        }
        
        // Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitDao().delete(exitExits);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Exit findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        
       return DAOFactory.getExitDao().findById(id);
    }

    @Override
    public List<Exit> findAll() throws Exception {
        return DAOFactory.getExitDao().findAll();
    }
    
}
