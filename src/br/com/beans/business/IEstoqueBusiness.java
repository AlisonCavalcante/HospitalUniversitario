/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Estoque;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IEstoqueBusiness {
    public List<Estoque> buscarEstoque(String fornecedor, String insumo,EntityManagerFactory emf)throws Exception;
    public boolean salvarEstoque(Estoque estoque, EntityManagerFactory emf)throws Exception;
    public boolean removerEstoque(Estoque estoque, EntityManagerFactory emf)throws Exception;
    public Estoque atualizarEstoque(Estoque estoque, EntityManagerFactory emf)throws Exception;
    public List<Estoque> buscarEstoquePorInsumo(Long id, EntityManagerFactory emf) throws Exception;
}
