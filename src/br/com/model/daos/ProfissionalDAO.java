/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;


import JpaUtil.JpaUtil;
import br.com.beans.Administrador;
import br.com.beans.Especializacao;
import br.com.beans.Pessoa;
import br.com.beans.ProfissionalDeSaude;
import br.com.beans.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class ProfissionalDAO extends GenericDAO{
   
 
   public ProfissionalDeSaude buscarProfissionalDeSaudePorCpf(String cpf, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       ProfissionalDeSaude profissionalDeSaude = null;
       
       try{
       String consulta = "select p from ProfissionalDeSaude p where p.cpf = :cpf"; 
       TypedQuery<ProfissionalDeSaude> query = em.createQuery(consulta, ProfissionalDeSaude.class); 
       query.setParameter("cpf", cpf);
       profissionalDeSaude = query.getSingleResult();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       }
        return profissionalDeSaude;
       }
    
   public boolean buscarProfissionalDeSaudePorApelido(String apelido, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       ProfissionalDeSaude profissionalDeSaude = null;
       
       try{
       String consulta = "select p from ProfissionalDeSaude p where p.apelido = :apelido"; 
       TypedQuery<ProfissionalDeSaude> query = em.createQuery(consulta, ProfissionalDeSaude.class); 
       query.setParameter("apelido", apelido);
       profissionalDeSaude = query.getSingleResult();
       }catch(Exception e){
        e.printStackTrace();
           return false;
       }finally{
       em.close();
       }
        return true;
       }
   
   
    public List<ProfissionalDeSaude> buscarProfissionalDeSaudePorNome(String nome, EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       List<ProfissionalDeSaude> profissionalDeSaudes = null;
       
       try{
       String consulta = "select p from ProfissionalDeSaude p where p.nome = :nome"; 
       TypedQuery<ProfissionalDeSaude> query = em.createQuery(consulta, ProfissionalDeSaude.class); 
       query.setParameter("nome", nome);
       profissionalDeSaudes = query.getResultList();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       } 
        return profissionalDeSaudes;
      }
      
       public ProfissionalDeSaude find(Object o, EntityManagerFactory emf, Long id) {
        EntityManager em = emf.createEntityManager();
        ProfissionalDeSaude profissionalDeSaude = (ProfissionalDeSaude) em.find(ProfissionalDeSaude.class, id);
        return profissionalDeSaude;
    } 
 
}
