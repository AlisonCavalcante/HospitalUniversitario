/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Estoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class EstoqueDAO extends GenericDAO{
   
    
    public List<Estoque> buscarEstoquePorInsumo(Long id,EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       String consulta = "select e from Estoque e where e.insumo.id = :insumo_id"; 
       TypedQuery<Estoque> query = em.createQuery(consulta, Estoque.class);
       query.setParameter("insumo_id", id);
       List<Estoque> resultado ;
        
       return resultado = query.getResultList();
   }
    
    
    public Estoque find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Estoque estoque= (Estoque) em.find(Estoque.class, id);
        return estoque;
    } 
    
    
    
    
    
}
