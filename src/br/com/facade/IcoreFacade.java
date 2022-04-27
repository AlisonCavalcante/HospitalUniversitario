/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facade;

import br.com.beans.Administrador;
import br.com.beans.Atendente;
import br.com.beans.Cidade;
import br.com.beans.Endereco;
import br.com.beans.Especializacao;
import br.com.beans.Estado;
import br.com.beans.Estoque;
import br.com.beans.Insumo;
import br.com.beans.Paciente;
import br.com.beans.ProfissionalDeSaude;
import br.com.beans.Prontuario;
import br.com.beans.SalarioProfsaude;
import br.com.beans.Usuario;
import br.com.beans.ViewReset;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface IcoreFacade {
    
    public ProfissionalDeSaude buscarProfissionalDeSaudePorCpf(String cpf,EntityManagerFactory emf)throws Exception;
    public List<ProfissionalDeSaude> buscarProfissionalDeSaudePorNome(String nome, EntityManagerFactory emf)throws Exception;
    public boolean salvarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf)throws Exception;
    public boolean removerProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude,EntityManagerFactory emf)throws Exception;
    public ProfissionalDeSaude atualizarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude,EntityManagerFactory emf)throws Exception;
    
    
    public Paciente pesquisarPaciente(String cpf,EntityManagerFactory emf )throws Exception;
    public List<Paciente> pesquisarNomePaciente(String nome,EntityManagerFactory emf) throws Exception;
    public boolean salvarPaciente(Paciente paciente,EntityManagerFactory emf)throws Exception;
    public Paciente atualizarPaciente(Paciente paciente, EntityManagerFactory emf)throws Exception;
    public boolean removerPaciente(Paciente paciente, EntityManagerFactory emf)throws Exception;
    
    public Atendente buscarAtendentePorCpf(String cpf,EntityManagerFactory emf) throws Exception;
    public List<Atendente> buscarAtendentesPorNome(String nome,EntityManagerFactory emf)throws Exception;
    public boolean salvarAtendente(Atendente atendente,EntityManagerFactory emf)throws Exception;
    public boolean removerAtendente(Atendente atendente, EntityManagerFactory emf)throws Exception;
    public Atendente atualizarAtendente(Atendente atendente, EntityManagerFactory emf)throws Exception;
    
    public boolean salvarProntuario(Paciente paciente, ProfissionalDeSaude profissionalDeSaude,EntityManagerFactory emf)throws Exception;
    public boolean removerProntuario(Prontuario prontuario, EntityManagerFactory emf)throws Exception;
    public Prontuario atualizarProntuario(Prontuario prontuario, EntityManagerFactory emf)throws Exception;
    
    public boolean salvarAdministrador(Administrador administrador,EntityManagerFactory emf)throws Exception;    
    public boolean removerAdministrador(Administrador administrador, EntityManagerFactory emf)throws Exception;
    public Administrador  buscarAdministradorPorcpf(String cpf, EntityManagerFactory emf)throws Exception;
    public Administrador atualizarAdministrador(Administrador administrador, EntityManagerFactory emf)throws Exception;
    
    
    public List<Especializacao> listarEspecializacaos(EntityManagerFactory emf)throws Exception;
    public List<Especializacao> listarPorConselho(EntityManagerFactory emf, String conselho)throws Exception;
    public boolean salvarEspecializacao(Especializacao especializacao,EntityManagerFactory emf)throws Exception;
    public boolean  removerEspecializacao(Especializacao especializacao, EntityManagerFactory emf)throws Exception;
    public Especializacao atualizarEspecializacao(Especializacao especializacao, EntityManagerFactory emf)throws Exception;
    public Especializacao buscarEspecializacaoPorId(Long id, EntityManagerFactory emf)throws Exception;
    
    public Usuario verificarUsuario(String login, String senha,EntityManagerFactory emf)throws Exception;
    public boolean resetSenha(String login,String novaSenha,EntityManagerFactory emf)throws Exception;
    
    public boolean salvarCidade(Cidade cidade, EntityManagerFactory emf)throws Exception;
    public Cidade atualizarCidade(Cidade cidade, EntityManagerFactory emf)throws Exception;
    public boolean  removerCidade(Cidade cidade, EntityManagerFactory emf)throws Exception;
    public List<Cidade> listarCidadePornome(String nome, EntityManagerFactory emf)throws Exception;
    public Cidade pesquisarPorId(Long id, EntityManagerFactory emf)throws Exception;
            
    public boolean salvarEstado(Estado estado, EntityManagerFactory emf)throws Exception;
    public Estado buscarEstadoPornome(String nome, EntityManagerFactory emf)throws Exception;
    
    public boolean salvarEndereco(Endereco endereco, EntityManagerFactory emf)throws Exception;
    public Endereco buscarEndereco(String nome,EntityManagerFactory emf)throws Exception;
    public boolean removerEndereco(Endereco endereco, EntityManagerFactory entityManagerFactory)throws Exception;
    public List<Endereco> buscarEnderecosPorNome(String nome, EntityManagerFactory emf)throws Exception;
    public Endereco buscarEnderecoPorId(Long id, EntityManagerFactory emf)throws Exception;
    
    public List<Estoque> buscarEstoque(String fornecedor, String insumo,EntityManagerFactory emf)throws Exception;
    public boolean salvarEstoque(Estoque estoque, EntityManagerFactory emf)throws Exception;
    public boolean removerEstoque(Estoque estoque, EntityManagerFactory emf)throws Exception;
    public Estoque atualizarEstoque(Estoque estoque, EntityManagerFactory emf)throws Exception;
    public List<Estoque> buscarEstoquePorInsumo(Long id,EntityManagerFactory emf)throws Exception;
    
    public boolean salvarInsumo(Insumo insumo, EntityManagerFactory emf)throws Exception;
    public boolean removerInsumo(Insumo insumo, EntityManagerFactory emf)throws Exception;
    public Insumo atualizarInsumo(Insumo insumo, EntityManagerFactory emf)throws Exception;
    public Insumo buscarInsumoPorNome(String nome, EntityManagerFactory emf)throws  Exception;
    
    
    public List<ViewReset> listarResets(EntityManagerFactory emf)throws Exception;
    public List<SalarioProfsaude> listarSalarios(EntityManagerFactory emf) throws Exception;
}
