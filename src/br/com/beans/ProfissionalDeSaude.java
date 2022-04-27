/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

/**
 *
 * @author Alison
 */
@Entity
public class ProfissionalDeSaude extends Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
       
    @Column(nullable = false, length = 10)
    private float salario;
    @Column
    private double carga_horaria=60;
    @Column
    private double hora_extra;
    @Column
    private int quantidadePacientes;
    @Column(name = "apelido",unique = true,length = 10)
    private String apelido;
    @Column
    private String tipo;
    @Column(nullable = false)
    private String especializacao;
   
    @Transient
    private List<Especializacao> especializacoes;
   
    
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
        final ProfissionalDeSaude other = (ProfissionalDeSaude) obj;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     * @return the salario
     */
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     * @return the ativo
     */
    
    /**
     * @return the carga_horaria
     */
    public double getCarga_horaria() {
        return carga_horaria;
    }

    /**
     * @param carga_horaria the carga_horaria to set
     */
    public void setCarga_horaria(double carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    /**
     * @return the hora_extra
     */
    public double getHora_extra() {
        return hora_extra;
    }

    /**
     * @param hora_extra the hora_extra to set
     */
    public void setHora_extra(double hora_extra) {
        this.hora_extra = hora_extra;
    }

  

    /**
     * @return the quantidadePacientes
     */
    public int getQuantidadePacientes() {
        return quantidadePacientes;
    }

    /**
     * @param quantidadePacientes the quantidadePacientes to set
     */
    public void setQuantidadePacientes(int quantidadePacientes) {
        this.quantidadePacientes = quantidadePacientes;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the especializacao
     */
    public String getEspecializacao() {
        return especializacao;
    }

    /**
     * @param especializacao the especializacao to set
     */
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    /**
     * @return the especializacoes
     */
    public List<Especializacao> getEspecializacoes() {
        return especializacoes;
    }

    /**
     * @param especializacoes the especializacoes to set
     */
    public void setEspecializacoes(List<Especializacao> especializacoes) {
        this.especializacoes = especializacoes;
    }

    /**
     * @return the usuario
     */

    /**
     * @return the especializacoes
     */
    
    
}
