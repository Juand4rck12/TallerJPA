package co.edu.sena.stockclem.controller;

import co.edu.sena.stockclem.model.Presentation;
import co.edu.sena.stockclem.persistence.DAOFactory;
import co.edu.sena.stockclem.persistence.EntityManagerHelper;
import java.util.List;

/**
 * date :24/04/2025
 * @author Juan Diego
 * objetivo: crear los controladores para Presentation
 */
public class PresentationController implements IPresentationController {

    @Override
    public void insert(Presentation presentation) throws Exception {
        if (presentation == null) {
            throw new Exception("La presentación es obligatoria");
        }
        
        // Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationDAO().insert(presentation);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Presentation presentation) throws Exception {
        if (presentation == null) {
            throw new Exception("La presentación es obligatoria");
        }
        
        Presentation presentationExists = DAOFactory.getPresentationDAO().findById(
                presentation.getIdPresentation());
        if (presentationExists == null) {
            throw new Exception("No existe presentación con ese id");
        }
        
        // Actualizar
        presentationExists.setDescription(presentationExists.getDescription());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationDAO().insert(presentation);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        
        Presentation presentationExists = DAOFactory.getPresentationDAO().findById(id);
        if (presentationExists == null) {
            throw new Exception("No existe presentación con ese id");
        }
        
        // Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationDAO().delete(presentationExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Presentation findById(Long id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }

        return DAOFactory.getPresentationDAO().findById(id);

    }

    @Override
    public List<Presentation> findAll() throws Exception {
        return DAOFactory.getPresentationDAO().findAll();
    }
}
