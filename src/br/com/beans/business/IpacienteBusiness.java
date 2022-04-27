/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Paciente;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IpacienteBusiness {
    
    public Paciente pesquisarPaciente(String cpf,EntityManagerFactory emf) throws Exception;
    public List<Paciente> pesquisarNomePaciente(String nome,EntityManagerFactory emf) throws Exception;
    public boolean salvarPaciente(Paciente paciente,EntityManagerFactory emf)throws Exception;
    public Paciente atualizarPaciente(Paciente paciente, EntityManagerFactory emf) throws Exception;
    public boolean removerPaciente(Paciente paciente, EntityManagerFactory emf) throws Exception;
}
