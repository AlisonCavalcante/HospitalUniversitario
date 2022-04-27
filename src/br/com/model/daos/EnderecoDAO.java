/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class EnderecoDAO extends GenericDAO{
   
    
       public List<Endereco> buscarEnderecoPorNome(String nome, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       List<Endereco> enderecos = null;
       try{
       String consulta = "select e from Endereco e where e.nome = :nome"; 
       TypedQuery<Endereco> query = em.createQuery(consulta, Endereco.class);
       query.setParameter("nome", nome);
       enderecos = query.getResultList();
       }catch(Exception e){
         e.printStackTrace();
       }finally{
       em.close();
       } 
       return enderecos;
   }
    
    
        public Endereco find(Long id,EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Endereco endereco = (Endereco) em.find(Endereco.class, id);
        return endereco;
        } 
    
    
}
