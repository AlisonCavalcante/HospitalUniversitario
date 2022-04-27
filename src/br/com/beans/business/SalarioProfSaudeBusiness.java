/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.SalarioProfsaude;
import br.com.model.daos.SalarioProfSaudeDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class SalarioProfSaudeBusiness implements ISarioProfSaude{
    private SalarioProfSaudeDAO salarioProfSaudeDAO;
    public SalarioProfSaudeBusiness() {
        
        salarioProfSaudeDAO = new SalarioProfSaudeDAO();
    }

    @Override
    public List<SalarioProfsaude> listarSalarios(EntityManagerFactory emf) throws Exception {
       return this.salarioProfSaudeDAO.listarSalarios(emf);
    }
    
    
    
    
    
    
}
