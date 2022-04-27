/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.daos;

import br.com.beans.SalarioProfsaude;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alison
 */
public class SalarioProfSaudeDAO {
    
   
     public List<SalarioProfsaude> listarSalarios(EntityManagerFactory emf){
       EntityManager em = emf.createEntityManager();
       List<SalarioProfsaude> salarios = null;
       String consulta = "from SalarioProfsaude order by nome ";
       try{
       TypedQuery<SalarioProfsaude> query = em.createQuery(consulta, SalarioProfsaude.class);
       salarios= query.getResultList();
       }catch(Exception e){
       e.printStackTrace();
       }finally{
       em.close();
       }
       
       return salarios;
    } 
    
    
    
}
