/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Atendente;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IatendenteBusiness {
    public Atendente buscarAtendentePorCpf(String cpf,EntityManagerFactory emf) throws Exception;
    public List<Atendente> buscarAtendentesPorNome(String nome,EntityManagerFactory emf)throws Exception;
    public boolean salvarAtendente(Atendente atendente,EntityManagerFactory emf)throws Exception;
    public boolean removerAtendente(Atendente atendente, EntityManagerFactory emf) throws Exception;
    public Atendente atualizarAtendente(Atendente atendente, EntityManagerFactory emf) throws Exception;
}
