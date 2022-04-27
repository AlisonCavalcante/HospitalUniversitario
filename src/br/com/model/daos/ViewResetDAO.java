/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import br.com.beans.ViewReset;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class ViewResetDAO {

    public ViewResetDAO() {
    }
       public List<ViewReset> listarResets(EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       List<ViewReset> resets = null;
       String consulta = "from ViewReset order by nome ";
       try{
       TypedQuery<ViewReset> query = em.createQuery(consulta, ViewReset.class);
       resets = query.getResultList();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       }
       
       return resets;
    } 
    
    
}
