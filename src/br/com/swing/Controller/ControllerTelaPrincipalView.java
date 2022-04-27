/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.swing.Controller;

import br.com.beans.Atendente;
import br.com.beans.Pessoa;
import br.com.beans.ProfissionalDeSaude;
import br.com.beans.Usuario;
import br.com.facade.IcoreFacade;
import br.com.swing.view.LoginView;
import br.com.swing.view.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alison
 */
public class ControllerTelaPrincipalView implements ActionListener{

    private TelaPrincipalView telaPrincipalView;
    private Usuario usuario;
    private LoginView loginView;
    
    public ControllerTelaPrincipalView(TelaPrincipalView telaPrincipalView, IcoreFacade icoreFacade,Usuario usuario,LoginView loginView) {
        this.telaPrincipalView = telaPrincipalView;
        this.usuario = usuario;
        this.loginView = loginView;
        modificarTelaConformeUsuario(usuario);
        telaPrincipalView.getDelogarMenuItem().addActionListener(this);
        telaPrincipalView.getSairMenuItem().addActionListener(this);
    }
    
    public void modificarTelaConformeUsuario(Usuario usuario){
    
   if(usuario instanceof ProfissionalDeSaude){
       telaPrincipalView.getMenu_ItemAdm().setVisible(false);
       telaPrincipalView.getMenu_ItemAtendente().setVisible(false);
       telaPrincipalView.getMenu_IItemProfissional().setVisible(false);
       
   }
   if(usuario instanceof Atendente){
       telaPrincipalView.getMenu_IItemProfissional().setVisible(false);
       telaPrincipalView.getMenu_ItemAdm().setVisible(false);
   } 
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == telaPrincipalView.getSairMenuItem()){
        System.exit(0);
        }
        if(e.getSource() == telaPrincipalView.getDelogarMenuItem()){
            telaPrincipalView.setVisible(false);
            loginView.setVisible(true);
        }
    }
    
    
}
