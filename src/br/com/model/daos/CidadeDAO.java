/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class CidadeDAO extends GenericDAO{
    
    private static String Listar_Cidade = "from Cidade order by nome";
    

    public Cidade find(Long id ,EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Cidade cidade= (Cidade) em.find(Cidade.class, id);
        return cidade;
    } 
    
    public List<Cidade> listarCidadesPornome(String nome,EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager(); 
       String consulta = "select c from Cidade c where c.nome = :nome";
       TypedQuery<Cidade> query = em.createQuery(consulta, Cidade.class); 
       query.setParameter("nome",nome);
       List<Cidade> resultado;
       return resultado = query.getResultList();
    }
    
    public Cidade buscarCidadeNome(String nome,EntityManagerFactory emf){
      EntityManager em = emf.createEntityManager(); 
       String consulta = "select c from Cidade c where c.nome = :nome"; 
       TypedQuery<Cidade> query = em.createQuery(consulta, Cidade.class); 
       query.setParameter("nome",nome);
       Cidade resultado ;   
      return resultado = query.getSingleResult();
    }
    
}
