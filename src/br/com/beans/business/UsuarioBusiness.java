/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.Pessoa;
import br.com.beans.Usuario;
import br.com.model.daos.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author Alison
 */
public class UsuarioBusiness implements IusuarioBusiness{

    UsuarioDAO usuarioDAO;
    
    public UsuarioBusiness() {
        usuarioDAO = new UsuarioDAO();
    }
    
    @Override
    public Usuario verificarUsuario(String login, String senha, EntityManagerFactory emf) throws Exception {
       Usuario usuario;
       usuario = usuarioDAO.verificarLogin(emf,login);
       String cpfCriptografado = criptografarSenha(emf, usuario.getCpf());
       
       if(usuario.getSenha().equals(cpfCriptografado)){  //verificando primeiro acesso
           
           verificarSenha(usuario, emf);
           
       }
      String senhaCripto = criptografarSenha(emf, senha);
       if(usuario.getSenha().equals(senhaCripto)){
           System.out.println("Retornando o ususario");
          return usuario;
       }
       return null;
    }
    
    
  
    
    public String verificarSenha(Usuario usuario, EntityManagerFactory emf){
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite uma nova senha");
        String novasenha = ler.nextLine();
        while(usuario.getCpf().equals(novasenha)){ 
        System.out.println("Digite uma nova senha diferente de seu cpf!");
        novasenha = ler.nextLine();
        }
         String senhaCod = criptografarSenha(emf, novasenha);
           Usuario u = usuarioDAO.find(usuario, emf, usuario.getId());
           u.setSenha(senhaCod);
           usuarioDAO.merge(u, emf);
           
        return novasenha;
    }
    
    
    public String GerarLogin(EntityManagerFactory factory, Pessoa pessoa) {
        String[] nomes = pessoa.getNome().split(" ");
        String login = "";
        
        for (int i = 0; i < nomes.length; i++) {
            for (int j = 0; j < nomes.length; j++) {
                if (!(nomes[i].equals(nomes[j]))) {
                    login = nomes[i] + "." + nomes[j];
                    if ((usuarioDAO.verificarLogin(factory, login)) == null) {
                        return login;
                    }
                }
            }
        }
        
        for (int i = 0; i < nomes.length; i++) {
            for (int j = 0; j < nomes.length; j++) {
                if (!(nomes[i].equals(nomes[j]))) {
                    login = nomes[i] + "." + nomes[j];
//                     if (usuarioDAO.verificarLogin(factory, login + pessoa.getDataNascimento().get(GregorianCalendar.DAY_OF_MONTH)) == null) {
//                        return login + pessoa.getDataNascimento().get(GregorianCalendar.DAY_OF_MONTH);
//                    }
                }
            }
        }
        
       
        return null;

    }

    @Override
    public boolean resetSenha(String login, String novaSenha, EntityManagerFactory emf) throws Exception {
       
        
        return false;
    }
    
//     public String criptografarSenha(String original)
//	{
//		String senha = null;
//		MessageDigest algoritmo;
//		byte messageDigest[];
//		StringBuilder hexString;
//		try {
//			//algoritmo =MessageDigest.getInstance("SHA-256");// 64 letras
//			algoritmo = MessageDigest.getInstance("MD5");  // 32 letras
//			messageDigest = algoritmo.digest(original.getBytes("UTF-8"));
//			hexString = new StringBuilder();
//			for (byte b : messageDigest) {
//				hexString.append(String.format("%02X", 0xFF & b));
//			}
//			senha = hexString.toString();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		
//		} catch (UnsupportedEncodingException ex) {
//                        ex.printStackTrace();
//                }
//		System.out.println("Senha normal: "+original+" - Senha criptografada: "+senha);
//		return senha;
//	}       
    
     
     
     
     public String criptografarSenha(EntityManagerFactory emf, String senha){
     EntityManager em = emf.createEntityManager();
     StoredProcedureQuery query = em
    .createStoredProcedureQuery("criptografarsenha").registerStoredProcedureParameter("senha", String.class, ParameterMode.IN)
    .registerStoredProcedureParameter("cript", String.class, ParameterMode.OUT).setParameter("senha", senha);
    query.execute();
    String cripttografia = (String) query
    .getOutputParameterValue("cript");
            return cripttografia;
     }
     
}
