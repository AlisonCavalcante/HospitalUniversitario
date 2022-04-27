/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Endereco;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IEnderecoBusiness {
    
    public boolean salvarEndereco(Endereco endereco, EntityManagerFactory emf) throws Exception;
    public boolean removerEndereco(Endereco endereco, EntityManagerFactory entityManagerFactory)throws Exception;
    public List<Endereco> buscarEnderecosPorNome(String nome, EntityManagerFactory emf) throws Exception;
    public Endereco buscarEnderecoPorId(Long id, EntityManagerFactory emf) throws Exception;
}
