/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Alison
 */
@Entity
public class Prontuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column 
    private String observacoes;
    @Column(nullable = false)
    private Calendar dataAbertura;
    @Column
    private Calendar dataRetorno;
    
    private String prescicao;
    
    private String cids;
    
    private String codigo_Medico_Paciente;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prontuario)) {
            return false;
        }
        Prontuario other = (Prontuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.beans.Prontuario[ id=" + id + " ]";
    }

    /**
     * @return the cids
     */
    public String getCids() {
        return cids;
    }

    /**
     * @param cids the cids to set
     */
    public void setCids(String cids) {
        this.cids = cids;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the dataAbertura
     */
    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @return the dataRetorno
     */
    public Calendar getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(Calendar dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    /**
     * @return the prescicao
     */
    public String getPrescicao() {
        return prescicao;
    }

    /**
     * @param prescicao the prescicao to set
     */
    public void setPrescicao(String prescicao) {
        this.prescicao = prescicao;
    }

    /**
     * @return the codigo_Medico_Paciente
     */
    public String getCodigo_Medico_Paciente() {
        return codigo_Medico_Paciente;
    }

    /**
     * @param codigo_Medico_Paciente the codigo_Medico_Paciente to set
     */
    public void setCodigo_Medico_Paciente(String codigo_Medico_Paciente) {
        this.codigo_Medico_Paciente = codigo_Medico_Paciente;
    }

    
    
    
}
