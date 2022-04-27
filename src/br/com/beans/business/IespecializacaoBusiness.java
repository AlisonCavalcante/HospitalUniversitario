/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Especializacao;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IespecializacaoBusiness {
    
    public List<Especializacao> listarEspecializacaos(EntityManagerFactory emf)throws Exception;
    public List<Especializacao> listarPorConselho(EntityManagerFactory emf, String conselho)throws Exception;
    public Especializacao atualizarEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception;
    public boolean salvarEspecializacao(Especializacao especializacao,EntityManagerFactory emf)throws Exception;
    public boolean removerEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception;
    public Especializacao buscarEspecializacaoPorId(Long id, EntityManagerFactory emf) throws Exception;
    
}
