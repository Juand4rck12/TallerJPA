package com.market.marketprojectone.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


/**
 *
 * @author victus
 */
public class EntityManagerHelper2 {
    private static final EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> threadLocal;
    
    static {
        emf = Persistence.createEntityManagerFactory("asdksd");
        threadLocal = new ThreadLocal<EntityManager>();
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
        EntityManager manager = threadLocal.get();
        
        if (manager != null) manager.close();
    }
    
    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }
    
    public static void commit() {
        getEntityManager().getTransaction().commit();
    }
    
    public static void rollback() {
        if ((getEntityManager().getTransaction() != null) && 
            (getEntityManager().getTransaction().isActive()))
        {
            getEntityManager().getTransaction().rollback();
        }
    }
}
