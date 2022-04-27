/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alison
 */
@Entity
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private boolean reserva;
    @Column(nullable = false)
    private String fornecedor;
    @Column(nullable = false, length = 12)
    private int quantidade;
    @Column(nullable = false)
    private Calendar dataChegada;
    @Column(nullable = false)
    private Calendar dataValidade;
    @ManyToOne
    @JoinColumn(name = "insumo_id",nullable = false)
    private Insumo insumo;
    
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
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.beans.Estoque[ id=" + id + " ]";
    }

    /**
     * @return the tipo
     */

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the reserva
     */
    

    /**
     * @return the fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the dataChegada
     */
    public Calendar getDataChegada() {
        return dataChegada;
    }

    /**
     * @param dataChegada the dataChegada to set
     */
    public void setDataChegada(Calendar dataChegada) {
        this.dataChegada = dataChegada;
    }

    /**
     * @return the dataValidade
     */
    public Calendar getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * @return the insumo
     */
    public Insumo getInsumo() {
        return insumo;
    }

    /**
     * @param insumo the insumo to set
     */
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    /**
     * @return the reserva
     */
    public boolean isReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
    
    
    
    
}
