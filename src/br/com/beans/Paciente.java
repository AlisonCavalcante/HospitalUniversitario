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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Alison
 */
@Entity
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String alergias;
    @Column(nullable = false, length = 5)
    private String fator_rh;
    @Column(nullable = true)
    private boolean doador_orgaos;
    @Column(nullable = false, length = 5)
    private String tipaguem_sanguinea;
    
    private Date dataFalecimento;
    
    @OneToMany
    @JoinColumn(name = "paciente_id")
    private List<Prontuario> prontuarios;
   
    @ManyToMany(mappedBy="pacientes")
    private List<Pessoa> pessoas;
    
    @Override
    public Long getId() {
        return id;
    }

    public Paciente( String alergias, String fator_rh, boolean doador_orgaos, String tipaguem_sanguinea, Date dataFalecimento, String nome, String sexo, int idade, String email, String cpf, Date dataNascimento, List<Endereco> enderecos) {
        super(nome, sexo, idade, email, cpf, dataNascimento, enderecos);
        
        this.alergias = alergias;
        this.fator_rh = fator_rh;
        this.doador_orgaos = doador_orgaos;
        this.tipaguem_sanguinea = tipaguem_sanguinea;
        this.dataFalecimento = dataFalecimento;
        
    }

    public Paciente() {
    }

    
    
  
    
    
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.getAlergias());
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
        final Paciente other = (Paciente) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nome=" + getNome()+ " " + " "+ "cpf=" + getCpf() + " " +"id=" + id + " " +", alergias=" + getAlergias()+ "sexo"+ "  " +getSexo() + "fator_rh=" + getFator_rh() +" "+ "tipagem_sanguinea" + getTipaguem_sanguinea()  +'}';
    }

    /**
     * @return the alergias
     */
    public String getAlergias() {
        return alergias;
    }

    /**
     * @param alergias the alergias to set
     */
    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    /**
     * @return the fator_rh
     */
    public String getFator_rh() {
        return fator_rh;
    }

    /**
     * @param fator_rh the fator_rh to set
     */
    public void setFator_rh(String fator_rh) {
        this.fator_rh = fator_rh;
    }

    /**
     * @return the doador_orgaos
     */
    public boolean isDoador_orgaos() {
        return doador_orgaos;
    }

    /**
     * @param doador_orgaos the doador_orgaos to set
     */
    public void setDoador_orgaos(boolean doador_orgaos) {
        this.doador_orgaos = doador_orgaos;
    }

    /**
     * @return the tipaguem_sanguinea
     */
    public String getTipaguem_sanguinea() {
        return tipaguem_sanguinea;
    }

    /**
     * @param tipaguem_sanguinea the tipaguem_sanguinea to set
     */
    public void setTipaguem_sanguinea(String tipaguem_sanguinea) {
        this.tipaguem_sanguinea = tipaguem_sanguinea;
    }

    /**
     * @return the prontuarios
     */
    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    /**
     * @param prontuarios the prontuarios to set
     */
    public void setProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;
    }

    /**
     * @return the dataFalecimento
     */
   
    /**
     * @return the pessoas
     */
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    /**
     * @param pessoas the pessoas to set
     */
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    /**
     * @return the dataFalecimento
     */
    public Date getDataFalecimento() {
        return dataFalecimento;
    }

    /**
     * @param dataFalecimento the dataFalecimento to set
     */
    public void setDataFalecimento(Date dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    /**
     * @return the dataFalecimento
     */
   
    /**
     * @return the dataFalecimento
     */
    
    
    
}
