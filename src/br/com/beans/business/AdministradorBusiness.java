/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Administrador;
import br.com.model.daos.AdministradorDAO;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class AdministradorBusiness extends UsuarioBusiness implements IAdministradorBusiness{
    AdministradorDAO administradorDAO;
    
    
    public AdministradorBusiness() {
        administradorDAO = new AdministradorDAO();
    }

    @Override
    public boolean salvarAdministrador(Administrador administrador,EntityManagerFactory emf) throws Exception {
       String login = GerarLogin(emf, administrador);
       if(login != null){
       administrador.setLogin(login);
       administrador.setSenha(administrador.getCpf());
       return administradorDAO.persist(administrador, emf);
       }
       return true;
    }

    @Override
    public boolean removerAdministrador(Administrador administrador, EntityManagerFactory emf) throws Exception {
       if(administradorDAO.remove(administrador, emf)){
            return true;
        }
        return false;
    }

    @Override
    public Administrador buscarAdministradorPorcpf(String cpf, EntityManagerFactory emf) throws Exception {
        Administrador administrador = administradorDAO.buscarAdministradorPorCpf(cpf, emf);
        
        return administrador;
    }

    @Override
    public Administrador atualizarAdministrador(Administrador administrador, EntityManagerFactory emf) throws Exception { 
        if(administradorDAO.merge(administrador, emf)){
         return administrador;
        }
        return null;
    }
    
    
    
    
}
