package com.market.marketprojectone.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victus
 */
public class EntityManagerHelper {
    private static final EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> threadLocal;
    private static final Logger logger;
    
    static {
        emf = Persistence.createEntityManagerFactory("com.market_MarketProjectOne_jar_1.0-SNAPSHOTPU");
        threadLocal = new ThreadLocal<EntityManager>();
        logger = Logger.getLogger("com.market_MarketProjectOne_jar_1.0-SNAPSHOTPU");
        logger.setLevel(Level.ALL);
    }
    
    public static EntityManager getEntityManager() {
        EntityManager manager = threadLocal.get();
        
        if ((manager == null) || !manager.isOpen()) {
            manager = emf.createEntityManager();
            threadLocal.set(manager);
        }
        
        return manager;
    }
    
    public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        threadLocal.set(null);
        
        if (em != null) {
            em.close();
        }
    }
    
    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }
    
    public static void commit() {
        getEntityManager().getTransaction().commit();
    }
    
    public static void rollBack() {
        if ((getEntityManager().getTransaction()) != null &&
                (getEntityManager().getTransaction().isActive() == true)) {
            getEntityManager().getTransaction().rollback();
        }
    }
    
    public static Query createQuery(String query) {
        return getEntityManager().createQuery(query);
    }
    
    public static void flush() {
        getEntityManager().flush();
    }
    
    public static void log(String info, Level level, Throwable ex) {
        logger.log(level, info, ex);
    }
}
