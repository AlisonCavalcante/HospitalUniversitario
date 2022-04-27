/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplication;

import br.com.swing.Controller.ControllerLogin;
import br.com.swing.view.LoginView;

/**
 *
 * @author Alison
 */
public class AppSwing {
    
     public static void main(String[] args) {
        
         LoginView loginView = new LoginView();
         ControllerLogin controllerLogin = new ControllerLogin(loginView);
         loginView.setVisible(true);
         
     }
    
    
}
