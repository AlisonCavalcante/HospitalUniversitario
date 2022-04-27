/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Cidade;
import br.com.model.daos.CidadeDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class CidadeBusiness implements ICidadeBusiness{

    private CidadeDAO cidadeDAO;
    
    public CidadeBusiness() {
        cidadeDAO = new CidadeDAO();
    }

    @Override
    public boolean removerCidade(Cidade cidade, EntityManagerFactory emf) throws Exception {
        if(cidadeDAO.remove(cidade, emf)){
            return true;
        }
          return false;  
    }

    @Override
    public boolean salvarCidade(Cidade cidade, EntityManagerFactory emf) throws Exception {
         if(cidadeDAO.persist(cidade, emf)){
         return true;
         }
         return false;
    }

    @Override
    public Cidade atualizarCidade(Cidade cidade, EntityManagerFactory emf) throws Exception {
       if(cidadeDAO.merge(cidade, emf)){
           return cidade;
       }
       return null;
    }

    @Override
    public List<Cidade> listarCidadePornome(String nome, EntityManagerFactory emf) throws Exception {
         List<Cidade> cidades = cidadeDAO.listarCidadesPornome(nome, emf);
         
         if(cidades != null){
             return cidades;
         }
         return null;
    }

    @Override
    public Cidade pesquisarPorId(Long id, EntityManagerFactory emf) throws Exception {
        Cidade cidade = cidadeDAO.find(id, emf);
        if(cidade != null){
            return cidade;
        }
        
        return null;
    }
    
    
    
}
