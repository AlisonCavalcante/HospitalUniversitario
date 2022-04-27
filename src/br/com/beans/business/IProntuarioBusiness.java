/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Paciente;
import br.com.beans.ProfissionalDeSaude;
import br.com.beans.Prontuario;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IProntuarioBusiness {
     public boolean salvarProntuario(Paciente paciente, ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception;
     public boolean removerProntuario(Prontuario prontuario, EntityManagerFactory emf) throws Exception;
     public Prontuario atualizarProntuario(Prontuario prontuario, EntityManagerFactory emf)throws Exception;
}
