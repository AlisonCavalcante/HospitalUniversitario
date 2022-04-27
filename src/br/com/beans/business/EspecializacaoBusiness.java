/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Especializacao;
import br.com.model.daos.EspecializacaoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class EspecializacaoBusiness implements IespecializacaoBusiness{
    EspecializacaoDAO especializacaoDAO;
    
    public EspecializacaoBusiness() {
        especializacaoDAO = new EspecializacaoDAO();
    }
    
   public List<Especializacao> listarEspecializacaos(EntityManagerFactory emf)throws Exception{
       return this.especializacaoDAO.listarEspecializacaos(emf);
    }
    
    public List<Especializacao> listarPorConselho(EntityManagerFactory emf, String conselho)throws Exception{
       return this.especializacaoDAO.listarPorConselho(emf, conselho);
    }

    @Override
    public boolean salvarEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception {
        return this.especializacaoDAO.persist(especializacao, emf);
    }

    @Override
    public boolean removerEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception {
       if(especializacaoDAO.remove(especializacao, emf)){
         return true;
       }
       return false;
    }

    @Override
    public Especializacao atualizarEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception {
       if(especializacaoDAO.merge(especializacao, emf)){
           return  especializacao;
       }
        return null;
    }

    @Override
    public Especializacao buscarEspecializacaoPorId(Long id, EntityManagerFactory emf) throws Exception {
        Especializacao especializacao = especializacaoDAO.find(id, emf);
        if(especializacao != null){
            return especializacao;
        }
        return null;
    }
   
}
