/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Administrador;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IAdministradorBusiness {
    public boolean salvarAdministrador(Administrador administrador,EntityManagerFactory emf)throws Exception;
    public boolean removerAdministrador(Administrador administrador, EntityManagerFactory emf) throws Exception;
    public Administrador buscarAdministradorPorcpf(String cpf, EntityManagerFactory emf) throws Exception;
    public Administrador atualizarAdministrador(Administrador administrador, EntityManagerFactory emf) throws Exception;
}
