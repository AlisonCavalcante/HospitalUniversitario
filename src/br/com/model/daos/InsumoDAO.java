/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Insumo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class InsumoDAO extends GenericDAO{
    
    
    public List<Insumo> buscarInsumosPorNome(String nome,EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       String consulta = "select i from Insumo i where i.nome = :nome"; 
       TypedQuery<Insumo> query = em.createQuery(consulta, Insumo.class);
       query.setParameter("nome", nome);
       List<Insumo> resultado ;
        
       return resultado = query.getResultList();
   }
    
   public Insumo buscarInsumoPorNome(String nome,EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       String consulta = "select i from Insumo i where i.nome = :nome"; 
       TypedQuery<Insumo> query = em.createQuery(consulta, Insumo.class); 
       query.setParameter("nome", nome);
       Insumo resultado ;
        
        return resultado = query.getSingleResult();
     } 
   
   
    public Insumo find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Insumo insumo = (Insumo) em.find(Insumo.class, id);
        return insumo;
    } 
    
}
