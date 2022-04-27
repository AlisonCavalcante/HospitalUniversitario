/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans.business;

import br.com.beans.ViewReset;
import br.com.model.daos.ViewResetDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Alison
 */
public class ViewResetBusiness implements IViewReset{

    private ViewResetDAO viewResetDAO;
    
    public ViewResetBusiness() {
        viewResetDAO = new ViewResetDAO();
    }

    @Override
    public List<ViewReset> listarResets(EntityManagerFactory emf) throws Exception {
       List<ViewReset> viewResets = viewResetDAO.listarResets(emf);
      return viewResets; 
    }
    
}
