/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import br.com.beans.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public abstract class GenericDAO {
   
   public boolean persist(Object o, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o); 
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no método Pessoa.persist()");
            e.printStackTrace();
            return false;
        } finally {
            em.close(); 
        }
    }
  
    public boolean merge(Object o, EntityManagerFactory emf){
    EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); 
            em.merge(o);  
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {  
            System.out.println("Erro no método Pessoa.persist()");
            e.printStackTrace();
            return false;
        } finally {
            em.close(); 
        }
    
    }
    
    public boolean remove(Object o, EntityManagerFactory emf){
    EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Object c = em.merge(o);
            em.remove(c);  
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {  
            System.out.println("Erro no método Pessoa.persist()");
            e.printStackTrace();
            return false;
        } finally {
            em.close(); 
        }
    
    }
    
    
}
