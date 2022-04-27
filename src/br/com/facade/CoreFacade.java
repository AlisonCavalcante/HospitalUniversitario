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
import br.com.beans.business.AdministradorBusiness;
import br.com.beans.business.AtendenteBusiness;
import br.com.beans.business.CidadeBusiness;
import br.com.beans.business.EnderecoBusiness;
import br.com.beans.business.EspecializacaoBusiness;
import br.com.beans.business.EstadoBusiness;
import br.com.beans.business.EstoqueBusiness;
import br.com.beans.business.FuncionarioBusiness;
import br.com.beans.business.IAdministradorBusiness;
import br.com.beans.business.ICidadeBusiness;
import br.com.beans.business.IEnderecoBusiness;
import br.com.beans.business.IEstadoBusiness;
import br.com.beans.business.IEstoqueBusiness;
import br.com.beans.business.IFuncionarioBusiness;
import br.com.beans.business.IProntuarioBusiness;
import br.com.beans.business.ISarioProfSaude;
import br.com.beans.business.IViewReset;
import br.com.beans.business.IatendenteBusiness;
import br.com.beans.business.IespecializacaoBusiness;
import br.com.beans.business.InInsumoBusiness;
import br.com.beans.business.InsumoBusiness;
import br.com.beans.business.IpacienteBusiness;
import br.com.beans.business.IusuarioBusiness;
import br.com.beans.business.PacienteBusiness;
import br.com.beans.business.ProntuarioBusiness;
import br.com.beans.business.SalarioProfSaudeBusiness;
import br.com.beans.business.UsuarioBusiness;
import br.com.beans.business.ViewResetBusiness;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class CoreFacade implements IcoreFacade{

    IpacienteBusiness ipacienteBusiness;
    IFuncionarioBusiness iFuncionarioBusiness;
    InInsumoBusiness inInsumoBusiness;
    IatendenteBusiness iatendenteBusiness;
    IAdministradorBusiness iAdministradorBusiness;
    IusuarioBusiness iusuarioBusiness;
    IespecializacaoBusiness iespecializacaoBusiness;
    IEnderecoBusiness enderecoBusiness;        
    ICidadeBusiness cidadeBusiness;
    IProntuarioBusiness prontuarioBusiness;
    IEstoqueBusiness estoqueBusiness;
    IEstadoBusiness estadoBusiness;
    IViewReset iViewReset;        
    ISarioProfSaude iSarioProfSaude;
    
    private static CoreFacade coreFacade; 
    public static CoreFacade getInstance(){
    
     if(coreFacade == null){
         coreFacade = new CoreFacade();
     }
        return coreFacade;
    }
    
    
    public CoreFacade() {
        
        this.ipacienteBusiness = new PacienteBusiness();
        this.iespecializacaoBusiness = new EspecializacaoBusiness();
        this.iFuncionarioBusiness = new FuncionarioBusiness(iespecializacaoBusiness);
        this.inInsumoBusiness = new InsumoBusiness();
        this.iatendenteBusiness = new AtendenteBusiness();
        this.iAdministradorBusiness = new AdministradorBusiness();
        this.iusuarioBusiness = new UsuarioBusiness();
        this.enderecoBusiness = new EnderecoBusiness();
        this.cidadeBusiness = new CidadeBusiness();
        this.prontuarioBusiness = new ProntuarioBusiness(ipacienteBusiness,iFuncionarioBusiness);
        this.estoqueBusiness = new EstoqueBusiness();
        this.estadoBusiness = new EstadoBusiness();
        this.iViewReset = new ViewResetBusiness();
        this.iSarioProfSaude = new SalarioProfSaudeBusiness();
    }
       

    @Override
    public boolean salvarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude,EntityManagerFactory emf)throws Exception {
         return this.iFuncionarioBusiness.salvarProfissionalDeSaude(profissionalDeSaude,emf);
    }


    @Override
    public List<Estoque> buscarEstoque(String fornecedor, String insumo,EntityManagerFactory emf) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Endereco buscarEndereco(String nome,EntityManagerFactory emf) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfissionalDeSaude buscarProfissionalDeSaudePorCpf(String cpf,EntityManagerFactory emf) throws Exception {
       return this.iFuncionarioBusiness.buscarProfissionalDeSaudePorCpf(cpf,emf);
    }

    @Override
    public List<ProfissionalDeSaude> buscarProfissionalDeSaudePorNome(String nome,EntityManagerFactory emf) throws Exception {
       return this.iFuncionarioBusiness.buscarProfissionalDeSaudePorNome(nome,emf);
    }

    @Override
    public Paciente pesquisarPaciente(String cpf,EntityManagerFactory emf) throws Exception {
      return this.ipacienteBusiness.pesquisarPaciente(cpf,emf);
    }

    @Override
    public List<Paciente> pesquisarNomePaciente(String nome,EntityManagerFactory emf) throws Exception {
        return this.ipacienteBusiness.pesquisarNomePaciente(nome,emf);
    }

//    @Override
    public boolean salvarPaciente(Paciente paciente,EntityManagerFactory emf) throws Exception {
        return this.ipacienteBusiness.salvarPaciente(paciente,emf);
    }

    @Override
    public Atendente buscarAtendentePorCpf(String cpf,EntityManagerFactory emf) throws Exception {
        return this.iatendenteBusiness.buscarAtendentePorCpf(cpf,emf);
    }

    @Override
    public List<Atendente> buscarAtendentesPorNome(String nome,EntityManagerFactory emf) throws Exception {
        return this.iatendenteBusiness.buscarAtendentesPorNome(nome,emf);
    }

    @Override
    public boolean salvarAtendente(Atendente atendente,EntityManagerFactory emf) throws Exception {
      return this.iatendenteBusiness.salvarAtendente(atendente,emf);
    }

    @Override
    public boolean salvarAdministrador(Administrador administrador,EntityManagerFactory emf) throws Exception {
        return this.iAdministradorBusiness.salvarAdministrador(administrador,emf);
    }

    @Override
    public Usuario verificarUsuario(String login, String senha, EntityManagerFactory emf) throws Exception {
        return this.iusuarioBusiness.verificarUsuario(login, senha, emf);
    }

    @Override
    public boolean resetSenha(String login, String novaSenha, EntityManagerFactory emf) throws Exception {
        return this.iusuarioBusiness.resetSenha(login, novaSenha, emf);
    }

    @Override
    public boolean salvarProntuario(Paciente paciente, ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception {
        return this.prontuarioBusiness.salvarProntuario(paciente, profissionalDeSaude, emf);
    }

    @Override
    public List<Especializacao> listarEspecializacaos(EntityManagerFactory emf) throws Exception {
       return this.iespecializacaoBusiness.listarEspecializacaos(emf);
    }

    @Override
    public List<Especializacao> listarPorConselho(EntityManagerFactory emf, String conselho) throws Exception {
        return this.iespecializacaoBusiness.listarPorConselho(emf, conselho);
    }

    @Override
    public boolean removerProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception {
        return this.iFuncionarioBusiness.removerProfissionalDeSaude(profissionalDeSaude, emf);
    }

    @Override
    public ProfissionalDeSaude atualizarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception {
        return this.iFuncionarioBusiness.atualizarProfissionalDeSaude(profissionalDeSaude, emf);
    }

    @Override
    public boolean salvarEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception {
        return this.iespecializacaoBusiness.salvarEspecializacao(especializacao, emf);
    }

    @Override
    public boolean removerAtendente(Atendente atendente, EntityManagerFactory emf) throws Exception {
        return this.iatendenteBusiness.removerAtendente(atendente, emf);
    }

    @Override
    public boolean removerAdministrador(Administrador administrador, EntityManagerFactory emf) throws Exception {
        return this.iAdministradorBusiness.removerAdministrador(administrador, emf);
    }

    @Override
    public boolean removerEndereco(Endereco endereco, EntityManagerFactory entityManagerFactory) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean salvarEndereco(Endereco endereco, EntityManagerFactory emf) throws Exception {
       return this.enderecoBusiness.salvarEndereco(endereco, emf);
    }

    @Override
    public Administrador buscarAdministradorPorcpf(String cpf, EntityManagerFactory emf) throws Exception {
       return this.iAdministradorBusiness.buscarAdministradorPorcpf(cpf, emf);
    }

    @Override
    public boolean salvarCidade(Cidade cidade, EntityManagerFactory emf) throws Exception {
        return this.cidadeBusiness.salvarCidade(cidade, emf);
    }

    @Override
    public boolean removerCidade(Cidade cidade, EntityManagerFactory emf) throws Exception {
        return this.cidadeBusiness.removerCidade(cidade, emf);
    }

    @Override
    public List<Endereco> buscarEnderecosPorNome(String nome, EntityManagerFactory emf) throws Exception {
        return this.enderecoBusiness.buscarEnderecosPorNome(nome, emf);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente, EntityManagerFactory emf) throws Exception {
        return this.ipacienteBusiness.atualizarPaciente(paciente, emf);
    }

    @Override
    public Atendente atualizarAtendente(Atendente atendente, EntityManagerFactory emf) throws Exception {
        return this.iatendenteBusiness.atualizarAtendente(atendente, emf);
    }

    @Override
    public Administrador atualizarAdministrador(Administrador administrador, EntityManagerFactory emf) throws Exception {
        return this.iAdministradorBusiness.atualizarAdministrador(administrador, emf);
    }

    @Override
    public boolean removerEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception {
       return this.iespecializacaoBusiness.removerEspecializacao(especializacao, emf);
    }

    @Override
    public Especializacao atualizarEspecializacao(Especializacao especializacao, EntityManagerFactory emf) throws Exception {
        return this.iespecializacaoBusiness.atualizarEspecializacao(especializacao, emf);
    }

    @Override
    public boolean removerPaciente(Paciente paciente, EntityManagerFactory emf) throws Exception {
        return this.ipacienteBusiness.removerPaciente(paciente, emf);
    }

    @Override
    public Cidade atualizarCidade(Cidade cidade, EntityManagerFactory emf) throws Exception {
        return this.cidadeBusiness.atualizarCidade(cidade, emf);
    }

    @Override
    public boolean removerProntuario(Prontuario prontuario, EntityManagerFactory emf) throws Exception {
        return this.prontuarioBusiness.removerProntuario(prontuario, emf);
    }

    @Override
    public Prontuario atualizarProntuario(Prontuario prontuario, EntityManagerFactory emf) throws Exception {
       return this.prontuarioBusiness.atualizarProntuario(prontuario, emf);
    }

    @Override
    public List<Cidade> listarCidadePornome(String nome, EntityManagerFactory emf) throws Exception {
       return this.cidadeBusiness.listarCidadePornome(nome, emf);
    }

    @Override
    public boolean salvarEstoque(Estoque estoque, EntityManagerFactory emf) throws Exception {
        return this.estoqueBusiness.salvarEstoque(estoque, emf);
    }

    @Override
    public boolean removerEstoque(Estoque estoque, EntityManagerFactory emf) throws Exception {
        return this.estoqueBusiness.removerEstoque(estoque, emf);
    }

    @Override
    public Estoque atualizarEstoque(Estoque estoque, EntityManagerFactory emf) throws Exception {
        return this.estoqueBusiness.atualizarEstoque(estoque, emf);
    }

    @Override
    public boolean salvarInsumo(Insumo insumo, EntityManagerFactory emf) throws Exception {
        return this.inInsumoBusiness.salvarInsumo(insumo, emf);
    }

    @Override
    public boolean removerInsumo(Insumo insumo, EntityManagerFactory emf) throws Exception {
        return this.inInsumoBusiness.removerInsumo(insumo, emf);
    }

    @Override
    public Insumo atualizarInsumo(Insumo insumo, EntityManagerFactory emf) throws Exception {
        return this.inInsumoBusiness.atualizarInsumo(insumo, emf);
    }

    @Override
    public Insumo buscarInsumoPorNome(String nome, EntityManagerFactory emf) throws Exception {
       return this.inInsumoBusiness.buscarInsumoPorNome(nome, emf);
    }

    @Override
    public List<Estoque> buscarEstoquePorInsumo(Long id, EntityManagerFactory emf) throws Exception {
      return this.estoqueBusiness.buscarEstoquePorInsumo(id, emf);
    }

    @Override
    public boolean salvarEstado(Estado estado,EntityManagerFactory emf) throws Exception {
       return this.estadoBusiness.salvarEstado(estado, emf);
    }

    @Override
    public Estado buscarEstadoPornome(String nome, EntityManagerFactory emf) throws Exception {
         return this.estadoBusiness.buscarEstadoPornome(nome, emf);
    }

    @Override
    public Cidade pesquisarPorId(Long id, EntityManagerFactory emf) throws Exception {
        return this.cidadeBusiness.pesquisarPorId(id, emf);
    }

    @Override
    public Endereco buscarEnderecoPorId(Long id, EntityManagerFactory emf) throws Exception {
        return this.enderecoBusiness.buscarEnderecoPorId(id, emf);
    }

    @Override
    public Especializacao buscarEspecializacaoPorId(Long id, EntityManagerFactory emf) throws Exception {
        return this.iespecializacaoBusiness.buscarEspecializacaoPorId(id, emf);
    }

    @Override
    public List<ViewReset> listarResets(EntityManagerFactory emf) throws Exception {
       return this.iViewReset.listarResets(emf);
    }

    @Override
    public List<SalarioProfsaude> listarSalarios(EntityManagerFactory emf) throws Exception {
         return this.iSarioProfSaude.listarSalarios(emf);
    }

   
    
    
    
    
}
