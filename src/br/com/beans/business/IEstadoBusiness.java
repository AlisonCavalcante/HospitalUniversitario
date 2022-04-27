/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Estado;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IEstadoBusiness {
    public boolean salvarEstado(Estado estado,EntityManagerFactory emf)throws Exception;
    public Estado buscarEstadoPornome(String nome, EntityManagerFactory emf)throws Exception;
}
