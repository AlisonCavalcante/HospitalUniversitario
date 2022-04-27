/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Estoque;
import br.com.model.daos.EstoqueDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class EstoqueBusiness implements IEstoqueBusiness{

    private EstoqueDAO estoqueDAO;
    
    public EstoqueBusiness() {
        
        estoqueDAO = new EstoqueDAO();
    }
    
    @Override
    public List<Estoque> buscarEstoque(String fornecedor, String insumo, EntityManagerFactory emf) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean salvarEstoque(Estoque estoque, EntityManagerFactory emf) throws Exception {
       if(estoqueDAO.persist(estoque, emf)){
        return true;   
       }    
       return false;
    }

    @Override
    public boolean removerEstoque(Estoque estoque, EntityManagerFactory emf) throws Exception {
        if(estoqueDAO.remove(estoque, emf)){
        return true;
        }
        return false;
    }

    @Override
    public Estoque atualizarEstoque(Estoque estoque, EntityManagerFactory emf) throws Exception {
        if(estoqueDAO.merge(estoque, emf)){
        return estoque;
        }
        return null;
    }

    @Override
    public List<Estoque> buscarEstoquePorInsumo(Long id, EntityManagerFactory emf) throws Exception {
       List<Estoque> estoques;
        if(estoqueDAO.buscarEstoquePorInsumo(id, emf)!= null){
            estoques = estoqueDAO.buscarEstoquePorInsumo(id, emf);
            return estoques;
        }
        return null;
    }
    
}
