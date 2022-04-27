/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import br.com.beans.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class PessoaDAO extends GenericDAO{
       
     public Pessoa pesquisarPessoaCpf( String cpf,EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       String consulta = "select p from Pessoa p where p.cpf = :cpf"; 
       TypedQuery<Pessoa> query = em.createQuery(consulta, Pessoa.class);
       query.setParameter("cpf", cpf);
       Pessoa resultado ;
       return resultado = query.getSingleResult();
   }
    
    public List<Pessoa> pesquisarPessoasNome( String nome,EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       String consulta = "select p from Pessoa p where p.nome = :nome"; 
       TypedQuery<Pessoa> query = em.createQuery(consulta, Pessoa.class); 
       query.setParameter("nome", nome);
       List<Pessoa> resultado ;
      return resultado = query.getResultList();
   }
    
   public Pessoa find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = (Pessoa) em.find(Pessoa.class, id);
        return pessoa;
    } 
}
