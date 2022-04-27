/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Paciente;
import br.com.beans.Pessoa;
import br.com.beans.Prontuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class PacienteDAO extends GenericDAO{
        
    
   public Paciente buscarPacientePorCpf(String cpf, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       String consulta = "select p from Paciente p where p.cpf = :cpf"; 
       TypedQuery<Paciente> query = em.createQuery(consulta, Paciente.class); 
       query.setParameter("cpf", cpf);
       Paciente resultado ;
        
       return resultado = query.getSingleResult();
    }

      public List<Paciente> buscarPacientesPorNome(String nome, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       String consulta = "select p from Paciente p where p.nome = :nome"; 
       TypedQuery<Paciente> query = em.createQuery(consulta, Paciente.class);  
       query.setParameter("nome", nome);
       List<Paciente> resultado ;
      
       return resultado = query.getResultList();
     }
   
      
      
      
     public Paciente find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Paciente paciente = (Paciente) em.find(Paciente.class, id);
        return paciente;
    } 
    
}
