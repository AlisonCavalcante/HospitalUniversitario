/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplication;


import JpaUtil.JpaUtil;
import br.com.beans.Administrador;
import br.com.beans.Atendente;
import br.com.beans.Cidade;
import br.com.beans.Endereco;
import br.com.beans.Especializacao;
import br.com.beans.Estado;
import br.com.beans.Estoque;
import br.com.beans.GerarRelátorios;
import br.com.beans.Insumo;
import br.com.beans.Paciente;
import br.com.beans.Pessoa;
import br.com.beans.ProfissionalDeSaude;
import br.com.beans.Prontuario;
import br.com.beans.SalarioProfsaude;
import br.com.beans.Usuario;
import br.com.beans.ViewReset;
import br.com.beans.business.UsuarioBusiness;
import br.com.facade.CoreFacade;
import br.com.model.daos.AdministradorDAO;
import br.com.model.daos.CidadeDAO;
import br.com.model.daos.EnderecoDAO;
import br.com.model.daos.EspecializacaoDAO;
import br.com.model.daos.EstadoDAO;
import br.com.model.daos.PacienteDAO;
import br.com.model.daos.PessoaDAO;
import br.com.model.daos.ProfissionalDAO;
import br.com.model.daos.ProntuarioDAO;
import br.com.model.daos.UsuarioDAO;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.internal.jpa.parsing.EscapeNode;

/**
 *
 * @author Alison
 */
public class HospitalUniversitario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        
//        EntityManager entitymanager = JpaUtil.fabricaDeConexoes().createEntityManager();
//        entitymanager.getTransaction().begin();
//        
//        Estado estado = new Estado();
//        Estado estado1 = new Estado();
//        
//        estado.setNome("Ceara");
//        estado.setUf("CE");
//         
//        estado1.setNome("Piaui");
//        estado1.setUf("PI");
//        
//        entitymanager.persist(estado);
//        entitymanager.persist(estado1);
//        
//        Endereco endereco = new Endereco();
//        Endereco endereco1= new Endereco();
//        
//        Cidade cidade = new Cidade();
//        Cidade cidade1 = new Cidade();
//        
//        cidade.setNome("Serra talhada");
//        cidade.setEstado(estado);
//        cidade1.setNome("Floresta");
//        cidade1.setEstado(estado1);
//        
//        entitymanager.persist(cidade);
//        entitymanager.persist(cidade1);
//        
//        
//        endereco.setBairro("AABB");
//        endereco.setCep(13245);
//        endereco.setCidade(cidade);
//        endereco.setLogradouro("Centro");
//        
//        endereco1.setBairro("Tancredo");
//        endereco1.setCep(3455);
//        endereco1.setCidade(cidade1);
//        endereco1.setLogradouro("Quadra-09");
//      
//        entitymanager.persist(endereco);
//        entitymanager.persist(endereco1);
//        
//        
//        List<Endereco> enderecos = new ArrayList<>();
//        enderecos.add(endereco);
//        enderecos.add(endereco1);
//     
//        Paciente paciente = new Paciente();
//        Paciente paciente1 = new Paciente();
//        
//        paciente.setNome("Mael");
//        paciente.setSexo("Masculino");
//        paciente.setAlergias("acaro");
//        paciente.setCpf("234567");
//        paciente.setFator_rh("nao");
//        paciente.setDoador_orgaos(false);
//        paciente.setTipaguem_sanguinea("O+");
//        paciente.setEnderecos(enderecos);
//        
//        paciente1.setNome("Felipe");
//        paciente1.setSexo("Masculino");
//        paciente1.setAlergias("cachorro");
//        paciente1.setCpf("23998567");
//        paciente1.setFator_rh("nao");
//        paciente1.setDoador_orgaos(true);
//        paciente1.setTipaguem_sanguinea("A");
//        paciente1.setEnderecos(enderecos);
//        
//        
//        entitymanager.persist(paciente);
//        entitymanager.persist(paciente1);
//        entitymanager.getTransaction( ).commit( );
//        entitymanager.close( );
    

// Listar estado por nome
//        CidadeDAO cidadeDAO = new CidadeDAO();
//        
//        List<Cidade> cidade = cidadeDAO.listarCidades(JpaUtil.fabricaDeConexoes());
//        
//        for(Cidade c : cidade){
//            System.out.println("nome"+c.getNome());
//        }
//       

//        ProfissionalDeSaude profissionalDeSaude = new ProfissionalDeSaude();
//        List<Paciente> paciente;
//        
//        profissionalDeSaude.setNome("Joao");
//        profissionalDeSaude.setCpf("09876");
//        profissionalDeSaude.setCarga_horaria(7654);
//        profissionalDeSaude.setAtivo(true);
//        profissionalDeSaude.setSexo("Masculino");
//        profissionalDeSaude.setHora_extra(98);
//        profissionalDeSaude.setSalario(6500);
        
//        ProfissionalDAO profissionalDAO =new ProfissionalDAO();
//        profissionalDAO.persist(profissionalDeSaude,JpaUtil.fabricaDeConexoes());
        
        
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        profissionalDeSaude1 = (ProfissionalDeSaude)pessoaDAO.pesquisarPessoaNome("", "Joao", JpaUtil.fabricaDeConexoes());
//        
//        System.out.println(profissionalDeSaude1.toString() +" "+profissionalDeSaude1.getNome() +" "+ profissionalDeSaude1.getCpf());
//        
//        PacienteDAO pacienteDAO = new PacienteDAO();
//        paciente = pacienteDAO.buscarPacientesPorNome("Mael", JpaUtil.fabricaDeConexoes());
//        for(Paciente p : paciente){
//        System.out.println(p.toString());
//        
//        }
//        Especializacao especializacao = new Especializacao();
//        especializacao.setTipo("Pediatra");
//        especializacao.setRegistro("CRM");
//        especializacao.setCodigoRegistro(1324546575);
//        
//        EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO();
//        especializacaoDAO.persist(especializacao, JpaUtil.fabricaDeConexoes());
//        
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("Manoel");
//        pessoa.setSexo("Masculino");
//        pessoa.setCpf("8765567");
//        Calendar calendar;
//        calendar = Calendar.getInstance();
//        calendar.set(2018, 7, 10);
//        pessoa.setDataNascimento(calendar);
//        
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        pessoaDAO.persist(pessoa,JpaUtil.fabricaDeConexoes());
//        
//       
//        
//        
//        CoreFacade  coreFacade = new CoreFacade();
//        Paciente paciente = new Paciente();
//        paciente.setNome("Tico");
//        try {
//            coreFacade.salvarPaciente(paciente, JpaUtil.fabricaDeConexoes());
//          
//        } catch (Exception ex) {
//           ex.printStackTrace();
//        }
//
//        EntityManager entitymanager = JpaUtil.fabricaDeConexoes().createEntityManager();
//        entitymanager.getTransaction().begin();
//
//
//        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
//
//        Prontuario prontuario = new Prontuario();
//        Prontuario prontuario1 = new Prontuario();
//        
//        prontuario.setObservacoes("testando 1 ");
//        prontuario1.setObservacoes("testando 2");
//       
//        entitymanager.persist(prontuario);
//        entitymanager.persist(prontuario1);
//        
//        List<Prontuario> prontuarios = new ArrayList<>();
//        
//        prontuarios.add(prontuario);
//        prontuarios.add(prontuario1);
//        
//        for (Prontuario p : prontuarios) {
//            System.out.println(p.getObservacoes());
//        }
//        
//        Paciente paciente = new Paciente();
//        paciente.setNome("Teste5");
//        paciente.setCpf("9999");
//        paciente.setSexo("Masculino");
//        paciente.setProntuarios(prontuarios);
//        
//        entitymanager.persist(paciente);
//        
//        entitymanager.getTransaction( ).commit( );
//        entitymanager.close( );

//        EntityManager entitymanager = JpaUtil.fabricaDeConexoes().createEntityManager();
//        entitymanager.getTransaction().begin();
//        
//        Administrador administrador = new Administrador();
//        administrador.setNome("Ze");
//        administrador.setCpf("7886");
//        administrador.setLogin("Ze");
//        administrador.setSenha("345");
//        entitymanager.persist(administrador);
// 
//
//        entitymanager.getTransaction( ).commit( );
//        entitymanager.close( );
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        Usuario usuario = new Usuario();
//        usuario.setNome("Jose");
//        usuario.setCpf("444");
//        usuario.setSexo("Maculino");
//        usuario.setLogin("Jo");
//        usuario.setSenha("111");
//        usuarioDAO.persist(usuario, JpaUtil.fabricaDeConexoes());
    
    CoreFacade coreFacade = new CoreFacade();
   
//    Atendente atendente = new Atendente();
//    atendente.setNome("Mael Furtuoso");
//    atendente.setCpf("774488");
//    atendente.setSexo("Masculino");
//    Especializacao especializacao = new Especializacao();
//    especializacao.setConselho("CRM");
//    especializacao.setCodigo("10099");
//    especializacao.setTipo("Pediatra");
    
        try {
//          ProfissionalDeSaude profissionalDeSaude = coreFacade.buscarProfissionalDeSaudePorCpf("1000", JpaUtil.fabricaDeConexoes());
//          coreFacade.removerProfissionalDeSaude(profissionalDeSaude, JpaUtil.fabricaDeConexoes());

//         coreFacade.salvarEspecializacao(especializacao, JpaUtil.fabricaDeConexoes());
//         List<Especializacao> especializacaos = new ArrayList<>();
//         especializacaos.add(especializacao);
//         
//         ProfissionalDeSaude profissionalDeSaude = new ProfissionalDeSaude();
//         profissionalDeSaude.setNome("Paulo  Cavalcante");
//         profissionalDeSaude.setCpf("00012");
//         profissionalDeSaude.setSexo("Masculino");
//         profissionalDeSaude.setSalario(10000);
//         profissionalDeSaude.setEnderecos(enderecos);
//         profissionalDeSaude.setEspecializacoes(especializacaos);
//         coreFacade.salvarProfissionalDeSaude(profissionalDeSaude, JpaUtil.fabricaDeConexoes());
//        Paciente paciente = new Paciente();
//        paciente.setNome("Janiscleide");
//        paciente.setCpf("3377");
//        paciente.setSexo("Feminino");
//        Paciente paciente = coreFacade.pesquisarPaciente("44332211", JpaUtil.fabricaDeConexoes());
//        ProfissionalDeSaude profissionalDeSaude = coreFacade.buscarProfissionalDeSaudePorCpf("012212", JpaUtil.fabricaDeConexoes());
//        coreFacade.salvarProntuario(paciente, profissionalDeSaude, JpaUtil.fabricaDeConexoes());
//         coreFacade.salvarPaciente(paciente, JpaUtil.fabricaDeConexoes());
//        Paciente paciente =coreFacade.pesquisarPaciente("44332211", JpaUtil.fabricaDeConexoes());
//        ProfissionalDeSaude profissionalDeSaude =coreFacade.buscarProfissionalDeSaudePorCpf("012212", JpaUtil.fabricaDeConexoes());
//        coreFacade.salvarProntuario(paciente, profissionalDeSaude, JpaUtil.fabricaDeConexoes());
//            Insumo insumo = new Insumo();
//            insumo.setNome("amoxilina");
//            insumo.setTipo("medicamento");
//            insumo.setGenerico(false);
//            coreFacade.salvarInsumo(insumo, JpaUtil.fabricaDeConexoes());
//        Insumo insumo = coreFacade.buscarInsumoPorNome("amoxilina", JpaUtil.fabricaDeConexoes());
//        GregorianCalendar dataDeAbertura = new GregorianCalendar();
//            Estoque estoque = new Estoque();
//            estoque.setQuantidade(50);
//            estoque.setFornecedor("Ultrafarma");
//            estoque.setReserva(false);
//            estoque.setDataChegada(dataDeAbertura);
//            estoque.setDataValidade(dataDeAbertura);
//            estoque.setInsumo(insumo);
//            coreFacade.salvarEstoque(estoque, JpaUtil.fabricaDeConexoes());
//        coreFacade.verificarUsuario("Gabriel.Gregorio", "2098",JpaUtil.fabricaDeConexoes());
//            coreFacade.salvarProntuario("", profissionalDeSaude, emf)
//        List<Estoque> estoques;  
//              estoques = coreFacade.buscarEstoquePorInsumo(insumo.getId(), JpaUtil.fabricaDeConexoes());    
//           Estoque e= null;
//            for (Estoque estoque : estoques) {
//                
//                if(estoque.getQuantidade() == 50){
//                    e = estoque;
//                }
//                
//            }
//        coreFacade.removerEstoque(e, JpaUtil.fabricaDeConexoes());

//        Estado estado = new Estado();
//        estado.setNome("Alagoas");
//        estado.setUf("AL");
//        coreFacade.salvarEstado(estado, JpaUtil.fabricaDeConexoes());
//        Estado e = coreFacade.buscarEstadoPornome("Alagoas", JpaUtil.fabricaDeConexoes());
////        
//        Cidade cidade = new Cidade();
//        cidade.setNome("Delmiro");
//        cidade.setEstado(e);
//        coreFacade.salvarCidade(cidade, JpaUtil.fabricaDeConexoes());
//        
//        
//        
//        Cidade ci = coreFacade.pesquisarPorId(new Long(1), JpaUtil.fabricaDeConexoes());
//        Endereco endereco = new Endereco();
//        endereco.setCep(599556);
//        endereco.setLogradouro("Av Buarque Santos");
//        endereco.setBairro("BTN");
//        endereco.setCidade(ci);
//
//        coreFacade.salvarEndereco(endereco, JpaUtil.fabricaDeConexoes());
//        Calendar calendar;
//        calendar = Calendar.getInstance();
//        calendar.set(2018, 7, 10);
////////////
////////////        
//        List<Endereco> enderecos = new ArrayList<>();
//        Endereco end = coreFacade.buscarEnderecoPorId(new Long(2), JpaUtil.fabricaDeConexoes());
//        enderecos.add(end);
////
//         Atendente atendente = new Atendente();
//         atendente.setNome("Janiscleide Silva");
//         atendente.setCpf("774488");
//         atendente.setSexo("Feminino");
//         atendente.setAtivo(true);
//         atendente.setDataNascimento(calendar);
//         atendente.setSalario(1500);
//         atendente.setIdade(35);
//         atendente.setEnderecos(enderecos);
//         coreFacade.salvarAtendente(atendente, JpaUtil.fabricaDeConexoes());

//            Administrador administrador = new Administrador();
//            administrador.setNome("Jose Neto");
//            administrador.setCpf("44000");
//            administrador.setSexo("Masculino");
//            administrador.setSalario(5000);
//            administrador.setIdade(25);
//            administrador.setAtivo(true);
//            administrador.setDataNascimento(calendar);
//            administrador.setEnderecos(enderecos);
//            coreFacade.salvarAdministrador(administrador, JpaUtil.fabricaDeConexoes());
//         List<Especializacao> especializacaos = new ArrayList<>();
//         Especializacao especializacao = coreFacade.buscarEspecializacaoPorId(new Long(1), JpaUtil.fabricaDeConexoes());
//         especializacaos.add(especializacao);
//////////         
//         ProfissionalDeSaude profissionalDeSaude = new ProfissionalDeSaude();
//         profissionalDeSaude.setNome("Washington Luiz");
//         profissionalDeSaude.setCpf("99887744");
//         profissionalDeSaude.setSexo("Masculino");
//         profissionalDeSaude.setAtivo(false);
//         profissionalDeSaude.setIdade(25);
//         profissionalDeSaude.setSalario(10000);
//         profissionalDeSaude.setEnderecos(enderecos);
//         profissionalDeSaude.setDataNascimento(calendar);
//         profissionalDeSaude.setEspecializacoes(especializacaos);
//         coreFacade.salvarProfissionalDeSaude(profissionalDeSaude, JpaUtil.fabricaDeConexoes());
//            Paciente paciente = coreFacade.pesquisarPaciente("5052", JpaUtil.fabricaDeConexoes());
//            ProfissionalDeSaude profissionalDeSaude = coreFacade.buscarProfissionalDeSaudePorCpf("00455", JpaUtil.fabricaDeConexoes());
//            coreFacade.salvarProntuario(paciente, profissionalDeSaude, JpaUtil.fabricaDeConexoes());
//        Paciente paciente = new Paciente();
//        paciente.setNome("Maria Dantas");
//        paciente.setCpf("5052777");
//        paciente.setSexo("Feminino");
//        paciente.setIdade(40);
//        paciente.setDoador_orgaos(true);
//        paciente.setDataNascimento(calendar);
//        paciente.setTipaguem_sanguinea("A");
//        paciente.setFator_rh("+");
//        paciente.setEnderecos(enderecos);
////        
//        coreFacade.salvarPaciente(paciente, JpaUtil.fabricaDeConexoes());
//        coreFacade.verificarUsuario("Cavalcante.Paulo", "111000", JpaUtil.fabricaDeConexoes

//            GerarRelátorios g = new GerarRelátorios();
//            g.gerarRelatorioTeste("Chico","1234","t2.pdf");
            
//        String nome = "Rafa.doid.doido";
//    
//        String [] nomes = nome.split(".");
//        System.out.println(nomes.length);
//        for (int i = 0; i < nomes.length; i++) {
//            System.out.println(nomes[i]);
//            
//        }
//       List<SalarioProfsaude> salarios = coreFacade.listarSalarios(JpaUtil.fabricaDeConexoes());
//           
//           
//            for (SalarioProfsaude salario : salarios) {
//                System.out.println(salario.getNome() +" "+ salario.getCpf()+""+ salario.getAtivo());
//            }
//       
        

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}