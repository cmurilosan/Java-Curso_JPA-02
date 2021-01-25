package br.com.alura.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionPersistence {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
