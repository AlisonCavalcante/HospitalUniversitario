/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Estado;
import br.com.model.daos.EstadoDAO;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class EstadoBusiness implements IEstadoBusiness{

    private EstadoDAO estadoDAO;
     
    public EstadoBusiness() {
        estadoDAO = new EstadoDAO();
    }

    @Override
    public boolean salvarEstado(Estado estado,EntityManagerFactory emf) throws Exception {
        if(estadoDAO.persist(estado, emf)){
            return true;
        }
       return false;     
    }

    @Override
    public Estado buscarEstadoPornome(String nome, EntityManagerFactory emf) throws Exception {
       Estado estado = estadoDAO.buscarEstadoNome(nome, emf);
       if(estado != null){
           return estado;
       }
       return null;
    }
    
}
