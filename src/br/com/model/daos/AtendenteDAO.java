/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Atendente;
import br.com.beans.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class AtendenteDAO extends GenericDAO{


    public Atendente find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Atendente atendente = (Atendente) em.find(Atendente.class, id);
        return atendente;
    }  
    
    
   public Atendente buscarAtendentePorCpf(String cpf, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       Atendente atendente = null;
       try{
       String consulta = "select a from Atendente a where a.cpf = :cpf"; 
       TypedQuery<Atendente> query = em.createQuery(consulta, Atendente.class); 
       query.setParameter("cpf", cpf);
       atendente = query.getSingleResult();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       }
       return atendente;
   }
   
   
   public List<Atendente> buscarAtendentesPorNome(String nome, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       List<Atendente> atendentes = null;
       try{
       String consulta = "select a from Atendente a where a.nome = :nome"; 
       TypedQuery<Atendente> query = em.createQuery(consulta, Atendente.class);
       query.setParameter("nome", nome);
       atendentes = query.getResultList();
       }catch(Exception e){
         e.printStackTrace();
       }finally{
       em.close();
       } 
       return atendentes;
   }

}
