/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.swing.Controller;

import br.com.beans.Usuario;
import br.com.facade.CoreFacade;
import br.com.facade.IcoreFacade;
import br.com.swing.view.LoginView;
import br.com.swing.view.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alison
 */
public class ControllerLogin implements  ActionListener{

    private LoginView loginView;
    private IcoreFacade icoreFacade;
    private Usuario usuario;
    private TelaPrincipalView telaPrincipalView;
    private ControllerTelaPrincipalView controllerTelaPrincipalView;
    
    
    public ControllerLogin(LoginView loginView) {
        icoreFacade = CoreFacade.getInstance();
        this.loginView = loginView;
        this.loginView.getLogarButton().addActionListener(this);
        this.loginView.getCancelarButton().addActionListener(this);
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginView.getCancelarButton()){
            System.exit(0);
        
        }
        if(e.getSource() == loginView.getLogarButton()){
            try {
            usuario  = icoreFacade.verificarUsuario(loginView.getLoginField().getText(), loginView.getSenhaField().getText(), JpaUtil.JpaUtil.fabricaDeConexoes());
                
            telaPrincipalView = new TelaPrincipalView();
            loginView.setVisible(false);
            telaPrincipalView.setVisible(true);
            controllerTelaPrincipalView = new ControllerTelaPrincipalView(telaPrincipalView, icoreFacade, usuario, loginView);
            
            } catch (Exception ex) {
                Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }    
        
    }
    
   
    
}
