/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Administrador;
import br.com.beans.Atendente;
import br.com.model.daos.AtendenteDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class AtendenteBusiness extends  UsuarioBusiness implements IatendenteBusiness{
    private AtendenteDAO atendenteDAO;

    
    public AtendenteBusiness() {
        atendenteDAO = new AtendenteDAO();
    }

    @Override
    public Atendente buscarAtendentePorCpf(String cpf,EntityManagerFactory emf) throws Exception {
        return this.atendenteDAO.buscarAtendentePorCpf(cpf,emf);
    }

    @Override
    public List<Atendente> buscarAtendentesPorNome(String nome,EntityManagerFactory emf) throws Exception {
        return this.atendenteDAO.buscarAtendentesPorNome(nome, emf);
    }

    @Override
    public boolean salvarAtendente(Atendente atendente,EntityManagerFactory emf) throws Exception {
        
        String login = GerarLogin(emf, atendente);
        if(login != null){
            atendente.setLogin(login);
            atendente.setSenha(criptografarSenha(emf, atendente.getCpf()));
            return atendenteDAO.persist(atendente,emf);
        }
        return false;
        
    }

    @Override
    public boolean removerAtendente(Atendente atendente, EntityManagerFactory emf) throws Exception {
         if(atendenteDAO.remove(atendente, emf)){
            return true;
        }
        return false;
    }

    @Override
    public Atendente atualizarAtendente(Atendente atendente, EntityManagerFactory emf) throws Exception { 
        if(atendenteDAO.merge(atendente, emf)){
           return atendente;
       }
       return null;
    }
    
    
    
    
}
