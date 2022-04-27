/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Prontuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class ProntuarioDAO extends GenericDAO{
    
   
    public Prontuario find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Prontuario prontuario = (Prontuario) em.find(Prontuario.class, id);
        return prontuario;
    } 
    
    
    
}
