/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Alison
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
     
    @Column(unique = true, length = 45)
    private String login;
    
    private String senha;
    
    private boolean ativo;
    
    @Column(nullable = false)
    private Boolean resetarSenha= false;
    
    
    
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the resetarSenha
     */
    public boolean isResetarSenha() {
        return resetarSenha;
    }

    /**
     * @param resetarSenha the resetarSenha to set
     */
    public void setResetarSenha(boolean resetarSenha) {
        this.resetarSenha = resetarSenha;
    }

    /**
     * @return the resetarSenha
     */
  
    
    
}
