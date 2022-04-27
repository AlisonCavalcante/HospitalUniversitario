/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Paciente;
import br.com.model.daos.PacienteDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class PacienteBusiness implements IpacienteBusiness{
    PacienteDAO pacienteDAO;
    
    public PacienteBusiness() {
        pacienteDAO = new PacienteDAO();
    }

    @Override
    public Paciente pesquisarPaciente(String cpf,EntityManagerFactory emf) throws Exception {
       if(pacienteDAO.buscarPacientePorCpf(cpf,emf) != null){
        return pacienteDAO.buscarPacientePorCpf(cpf,emf);
       }
       throw new Exception("Paciente não encontrado");
    }

    @Override
    public List<Paciente> pesquisarNomePaciente(String nome,EntityManagerFactory emf) throws Exception {
       return pacienteDAO.buscarPacientesPorNome(nome,emf);
    }

    @Override
    public boolean salvarPaciente(Paciente paciente,EntityManagerFactory emf) throws Exception {
        return pacienteDAO.persist(paciente,emf);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente, EntityManagerFactory emf) throws Exception {
        if(pacienteDAO.merge(paciente, emf)){
          return paciente;
        }
        return null;
    }

    @Override
    public boolean removerPaciente(Paciente paciente, EntityManagerFactory emf) throws Exception {
 
        if(pacienteDAO.remove(paciente, emf)){
         return true;
        }
        return false;
    }

 
    
} 
