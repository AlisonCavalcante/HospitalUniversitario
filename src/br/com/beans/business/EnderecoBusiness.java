/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Endereco;
import br.com.model.daos.EnderecoDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class EnderecoBusiness implements IEnderecoBusiness{

    private EnderecoDAO enderecoDAO;
    
    public EnderecoBusiness() {
        enderecoDAO = new EnderecoDAO();
    }    
    
    @Override
    public boolean salvarEndereco(Endereco endereco, EntityManagerFactory emf) throws Exception {
       return this.enderecoDAO.persist(endereco, emf);
    }

    @Override
    public boolean removerEndereco(Endereco endereco, EntityManagerFactory entityManagerFactory) throws Exception {
        if(enderecoDAO.remove(endereco, entityManagerFactory)){
            return true;
        }
        return false;
    }

    @Override
    public List<Endereco> buscarEnderecosPorNome(String nome, EntityManagerFactory emf) throws Exception {
        return this.enderecoDAO.buscarEnderecoPorNome(nome, emf);
    }

    @Override
    public Endereco buscarEnderecoPorId(Long id, EntityManagerFactory emf) throws Exception {
        Endereco endereco = enderecoDAO.find(id, emf);
        if(endereco!= null){
            return endereco;
        }
        return null;
    }
    
    
    
}
