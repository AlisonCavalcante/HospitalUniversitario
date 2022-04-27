/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.ProfissionalDeSaude;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IFuncionarioBusiness {
    
    public ProfissionalDeSaude buscarProfissionalDeSaudePorCpf(String cpf, EntityManagerFactory emf)throws Exception;
    public List<ProfissionalDeSaude> buscarProfissionalDeSaudePorNome(String nome, EntityManagerFactory emf)throws Exception;
    public boolean salvarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude,EntityManagerFactory emf)throws Exception;
    public boolean removerProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception;
    public ProfissionalDeSaude atualizarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude,EntityManagerFactory emf)throws Exception;
}
