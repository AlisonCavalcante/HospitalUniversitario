/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alison
 */
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    private int numero;
    @Column(nullable = false, length = 15)
    private int cep;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String bairro;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id",nullable = false)
    private Cidade cidade;
    @ManyToMany(mappedBy="enderecos")
    private List<Pessoa> Pessoas;
    
    
    public Endereco(){}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + this.getNumero();
        hash = 79 * hash + this.cep;
        hash = 79 * hash + Objects.hashCode(this.logradouro);
        hash = 79 * hash + Objects.hashCode(this.bairro);
        hash = 79 * hash + Objects.hashCode(this.cidade);
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
        final Endereco other = (Endereco) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", numero=" + getNumero() + ", cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }
    
    
 
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(int cep) {
        this.cep = cep;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
    
    
}
