/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Cidade;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface ICidadeBusiness {
    public boolean removerCidade(Cidade cidade, EntityManagerFactory emf) throws Exception;
    public boolean salvarCidade(Cidade cidade, EntityManagerFactory emf) throws Exception;
    public Cidade atualizarCidade(Cidade cidade, EntityManagerFactory emf) throws Exception;
    public List<Cidade> listarCidadePornome(String nome, EntityManagerFactory emf) throws Exception;
    public Cidade pesquisarPorId(Long id, EntityManagerFactory emf) throws Exception;
}
