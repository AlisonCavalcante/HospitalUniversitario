/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import JpaUtil.JpaUtil;
import br.com.beans.Especializacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class EspecializacaoDAO extends GenericDAO{
 
    private static String LISTAR_ESPECIALIZACOES = "from Especializacao order by tipo";

    public List<Especializacao> listarEspecializacaos(EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager(); 
       List<Especializacao> especializacoes = null;
       try{
       TypedQuery<Especializacao> query = em.createQuery(LISTAR_ESPECIALIZACOES, Especializacao.class);
       especializacoes = query.getResultList();
       }catch(Exception e){
           e.printStackTrace();
       }finally{
       em.close();
       }
       return especializacoes;
    }
    
    public List<Especializacao> listarPorConselho(EntityManagerFactory emf, String conselho){
       EntityManager em = emf.createEntityManager(); 
       List<Especializacao> especializacoes = null;
       try{
       String consulta ="select e from Especializacao e where e.conselho like :conselho"; 
       TypedQuery<Especializacao> query = em.createQuery(consulta, Especializacao.class);
       query.setParameter("conselho", "%"+conselho+"%");
       especializacoes = query.getResultList();
       }catch(Exception e){
           e.printStackTrace();
       }finally{
       em.close();
       }
       return especializacoes;
    }
    
    
    public Especializacao find(Long id, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Especializacao especializacao = (Especializacao) em.find(Especializacao.class, id);
        return especializacao;
    } 
    
}
