/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import br.com.aplication.AppFX;
import br.com.beans.Usuario;
import br.com.facade.CoreFacade;
import br.com.facade.IcoreFacade;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Alison
 */
public class ControlerLogin implements Initializable {

    @FXML
    private TextField textFLogin;

    @FXML
    private TextField textFSenha;

    @FXML
    private Button entrarButton;

    @FXML
    private Button sairButton;

    private IcoreFacade icoreFacade;
    private Usuario usuario;
    @FXML
    void actionButton(ActionEvent event) {
            
        if(event.getSource() == entrarButton){
            
            try {
                usuario = icoreFacade.verificarUsuario(textFLogin.getText(), textFSenha.getText(), JpaUtil.JpaUtil.fabricaDeConexoes());
                AppFX.changeStage("TelaPrincipal");
            
            } catch (Exception ex) {
                Logger.getLogger(ControlerLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        if(event.getSource() == sairButton){
        
            System.exit(0);
        }
        
        sairButton.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
            
                System.exit(0);
            
            }
        });
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       icoreFacade = CoreFacade.getInstance();
    }    
    
    
    
    
}
