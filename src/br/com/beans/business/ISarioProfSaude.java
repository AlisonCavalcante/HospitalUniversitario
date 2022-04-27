/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.SalarioProfsaude;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public interface ISarioProfSaude {
    public List<SalarioProfsaude> listarSalarios(EntityManagerFactory emf) throws Exception;
}
