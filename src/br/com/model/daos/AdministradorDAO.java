/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Administrador;
import br.com.beans.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class AdministradorDAO extends GenericDAO{
    
    
    public Administrador buscarAdministradorPorCpf(String cpf, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       Administrador administrador = null;
       
       try{
       String consulta = "select a from Administrador a where a.cpf = :cpf"; 
       TypedQuery<Administrador> query = em.createQuery(consulta, Administrador.class); 
       query.setParameter("cpf", cpf);
       administrador = query.getSingleResult();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       }
        return administrador;
       }
    
    
    public Administrador find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Administrador administrador = (Administrador) em.find(Administrador.class, id);
        return administrador;
    }  
    
    
}
