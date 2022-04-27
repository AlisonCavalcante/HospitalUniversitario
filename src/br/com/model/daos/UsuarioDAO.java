/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class UsuarioDAO extends GenericDAO{
  
    
    public Usuario verificarLogin(EntityManagerFactory emf,String login){
          EntityManager em = emf.createEntityManager();
          Usuario resultado = null;
          try{
          String consulta ="select u from Usuario u where u.login = :login";
          TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class); 
          query.setParameter("login", login);
          resultado = query.getSingleResult();
          }catch(Exception e){
          
          }finally{
          em.close();
          }
          return resultado;
        }
    
    public Usuario find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = (Usuario) em.find(Usuario.class, id);
        return usuario;
    } 
    
    
}
