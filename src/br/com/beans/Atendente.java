/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Alison
 */
@Entity
public class Atendente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable =  false, length = 10)
    private float salario;
    @Column
    private double carga_horaria;
    @Column
    private double hora_extra;

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Float.floatToIntBits(this.salario);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.carga_horaria) ^ (Double.doubleToLongBits(this.carga_horaria) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.hora_extra) ^ (Double.doubleToLongBits(this.hora_extra) >>> 32));
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
        final Atendente other = (Atendente) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Atendente{" + "id=" + id + ", salario=" + salario + ", carga_horaria=" + carga_horaria + ", hora_extra=" + hora_extra + '}';
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
     * @return the usuario
     */

    
}
