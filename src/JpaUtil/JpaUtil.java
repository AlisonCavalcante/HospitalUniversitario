/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JpaUtil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alison
 */
public class JpaUtil {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory fabricaDeConexoes() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("HospitalUniversitarioPU");
            return entityManagerFactory;
        } else {
            return entityManagerFactory;
        }
    }

}
