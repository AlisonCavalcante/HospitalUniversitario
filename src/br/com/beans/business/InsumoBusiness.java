/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Insumo;
import br.com.model.daos.InsumoDAO;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class InsumoBusiness implements InInsumoBusiness{

    private InsumoDAO insumoDAO;
    
    public InsumoBusiness() {
        insumoDAO = new InsumoDAO();
    }

    @Override
    public boolean salvarInsumo(Insumo insumo, EntityManagerFactory emf) throws Exception {
        if(insumoDAO.persist(insumo, emf)){
            return true;
        }
        return false;
    }

    @Override
    public boolean removerInsumo(Insumo insumo, EntityManagerFactory emf) throws Exception {
        if(insumoDAO.remove(insumo, emf)){
            return true;
        }  
        return false;
    }

    @Override
    public Insumo atualizarInsumo(Insumo insumo, EntityManagerFactory emf) throws Exception {
        if(insumoDAO.merge(insumo, emf)){
        return insumo;
        }
        return null;
    }

    @Override
    public Insumo buscarInsumoPorNome(String nome, EntityManagerFactory emf) throws Exception {
      if(insumoDAO.buscarInsumoPorNome(nome, emf) != null){
          Insumo insumo = insumoDAO.buscarInsumoPorNome(nome, emf);
          return insumo;
      }
      return null;
    }
   
}
