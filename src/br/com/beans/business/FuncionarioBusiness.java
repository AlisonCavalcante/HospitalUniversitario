/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Administrador;
import br.com.beans.Especializacao;
import br.com.beans.ProfissionalDeSaude;
import br.com.beans.Usuario;
import br.com.model.daos.ProfissionalDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class FuncionarioBusiness extends UsuarioBusiness implements IFuncionarioBusiness{

    ProfissionalDAO profissionalDAO;
    IespecializacaoBusiness iespecializacaoBusiness;
    public FuncionarioBusiness(IespecializacaoBusiness especializacaoBusiness) {
       profissionalDAO = new ProfissionalDAO();
       this.iespecializacaoBusiness = especializacaoBusiness;
    }

    @Override
    public ProfissionalDeSaude buscarProfissionalDeSaudePorCpf(String cpf,EntityManagerFactory emf) throws Exception {
        ProfissionalDeSaude profissionalDeSaude = profissionalDAO.buscarProfissionalDeSaudePorCpf(cpf, emf);
        if(profissionalDeSaude.getEspecializacao() != null){
        profissionalDeSaude.setEspecializacoes(desconverterEspecializacao(profissionalDeSaude.getEspecializacao(), emf));
        }
        
        return profissionalDeSaude;
        
    }

    @Override
    public List<ProfissionalDeSaude> buscarProfissionalDeSaudePorNome(String nome,EntityManagerFactory emf) throws Exception {
        return this.profissionalDAO.buscarProfissionalDeSaudePorNome(nome,emf);
    }

    @Override
    public boolean salvarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception {
          
          String login ="";
          profissionalDeSaude.setEspecializacao(converterEspecializacao(profissionalDeSaude.getEspecializacoes()));
          login = GerarLogin(emf, profissionalDeSaude);
          profissionalDeSaude.setApelido(gerarApelido(profissionalDeSaude.getNome(), emf));
          if(login != null){
              profissionalDeSaude.setLogin(login);
              String senha = criptografarSenha(emf,profissionalDeSaude.getCpf());
              profissionalDeSaude.setSenha(senha);
              return this.profissionalDAO.persist(profissionalDeSaude,emf);
          }
          return false;
                
    }

     @Override
    public ProfissionalDeSaude atualizarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception {
       
        if(profissionalDAO.merge(profissionalDeSaude, emf)){
            return  profissionalDeSaude;
       }
       return null;
    }
    
    
     @Override
    public boolean removerProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, EntityManagerFactory emf) throws Exception {
        if(profissionalDAO.remove(profissionalDeSaude, emf)){
            return true;
        }
        return false;
    }
    
    
   private String converterEspecializacao(List<Especializacao> especializacaos){
       String especializacao=""; 
       
       for (Especializacao especializacao1 : especializacaos) {
        especializacao += especializacao1.getConselho() + "/" + especializacao1.getCodigo() + ";";
       }
       return especializacao;
   }
   
   private List<Especializacao> desconverterEspecializacao(String especializacao, EntityManagerFactory emf) throws Exception{
       List<Especializacao> especializacoes = new ArrayList<>();
       String [] quebraUm = especializacao.split(";");
       
       for (int i = 0; i < quebraUm.length; i++) {
           Especializacao especializacao1 = iespecializacaoBusiness.listarPorConselho(emf, quebraUm[i].split("/")[0]).get(0);
           especializacao1.setCodigo(quebraUm[i].split("/")[1]);
           especializacoes.add(especializacao1);
       }
   
       return especializacoes;
   }
    
    private String gerarApelido( String nome, EntityManagerFactory emf)throws Exception{
        String apelido="";
        String [] nomes = nome.split(" ");
        apelido = nomes[0].substring(0, 1);
            for(int i = 1; i<nomes.length ;i++){
               if(profissionalDAO.buscarProfissionalDeSaudePorApelido(apelido, emf)){
                   apelido+=nomes[i].substring(0,1);
               }
            }
//            if(profissionalDAO.buscarProfissionalDeSaudePorApelido(apelido, emf)){
//                apelido += nomes[0].substring(1, 2); 
//               for(int i = 1; i< nomes.length ;i++){
//               if(profissionalDAO.buscarProfissionalDeSaudePorApelido(apelido, emf)){
//                apelido+=nomes[i].substring(1,2);
//               }else{
//                   return apelido.toUpperCase();
//               }
//            }
//                
//        }
            
     return apelido.toUpperCase();
    }
}
