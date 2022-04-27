/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Insumo;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface InInsumoBusiness {
 
    
    public boolean salvarInsumo(Insumo insumo, EntityManagerFactory emf)throws Exception;
    public boolean removerInsumo(Insumo insumo, EntityManagerFactory emf)throws Exception;
    public Insumo atualizarInsumo(Insumo insumo, EntityManagerFactory emf)throws Exception;
    public Insumo buscarInsumoPorNome(String nome, EntityManagerFactory emf)throws  Exception;
    
}
