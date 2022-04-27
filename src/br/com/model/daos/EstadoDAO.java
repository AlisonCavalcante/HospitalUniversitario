/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @sauthor Alison
 */
public class EstadoDAO extends GenericDAO{
    
    private static String Listar_Estados = "from Estado order by nome";
    
    
  public Estado find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Estado estoque = (Estado) em.find(Estado.class, id);
        return estoque;
    } 
 
    public List<Estado> listarEstado(EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       List<Estado> estados = null;
       
       try{
       TypedQuery<Estado> query = em.createQuery(Listar_Estados, Estado.class);
       estados = query.getResultList();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       }
       
       return estados;
    }
    
    public Estado buscarEstadoNome(String nome,EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       Estado estado = null;
       try{
       String consulta = "select e from Estado e where e.nome = :nome"; 
       TypedQuery<Estado> query = em.createQuery(consulta, Estado.class); 
       query.setParameter("nome",nome);
       estado = query.getSingleResult();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       }
          
      return estado;
    }
    

}
