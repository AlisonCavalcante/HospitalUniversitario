/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Alison
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 80)     
    private String nome;
    @Column(nullable = false, length = 10)
    private String sexo;
    @Column(nullable = false, length = 4)
    private int idade;
    @Column(length = 50)
    private String email;
    @Column(name = "cpf", nullable=false , unique=true, length = 11) 
    private String cpf;
    @Column(nullable = false)
    private Date dataNascimento;
            
   @ManyToMany
    @JoinTable(name="pessoa_dependentes", joinColumns=
    {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
      {@JoinColumn(name="pacient_id")})
    private List<Paciente> pacientes; 
    
    @ManyToMany
    @JoinTable(name="pessoa_enderecos", joinColumns=
    {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
      {@JoinColumn(name="endereco_id")})
    private List<Endereco> enderecos;

    public Pessoa(String nome, String sexo, int idade, String email, String cpf, Date dataNascimento, List<Endereco> enderecos) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public Pessoa() {
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.sexo);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + Objects.hashCode(this.getDataNascimento());
        hash = 79 * hash + Objects.hashCode(this.enderecos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + ", dataNascimento=" + getDataNascimento() + ", enderecos=" + enderecos + '}';
    }
   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the enderecos
     */
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * @param enderecos the enderecos to set
     */
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /**
     * @return the dataNascimento
     */
    

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the pacientes
     */
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * @param pacientes the pacientes to set
     */
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the dataNascimento
     */

    /**
     * @return the dataNascimento
     */
    
    
    
   
    
}
