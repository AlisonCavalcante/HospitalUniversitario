/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import br.com.aplication.AppFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Alison
 */
public class FXMLVboxTelaPrincipal implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MenuItem menuItemCadastrarPacientes;
    
    @FXML
    private MenuItem menuItemCadastrarProfissional;
    
    @FXML
    private MenuItem menuItemAtendente;
    
     @FXML
    private MenuItem menuITemAdmin;
    
     @FXML
    private AnchorPane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML
    void menuItem(ActionEvent event) {
        
        if(event.getSource() == menuItemCadastrarPacientes){
           AnchorPane a = (AnchorPane) AppFX.retornarPainel("TelaCadastroPacientes");
           pane.getChildren().setAll(a);
           
        }
        if(event.getSource() == menuItemCadastrarProfissional){
           AnchorPane a = (AnchorPane) AppFX.retornarPainel("TelaCadastroProfissionalSaude");
           pane.getChildren().setAll(a);
           
        }if(event.getSource() == menuItemAtendente){
           AnchorPane a = (AnchorPane) AppFX.retornarPainel("TelaCadastroAtendente");
           pane.getChildren().setAll(a);
           
        }if(event.getSource() == menuITemAdmin){
           AnchorPane a = (AnchorPane) AppFX.retornarPainel("TelaCadastroAdmin");
           pane.getChildren().setAll(a);
           
        }
        
        
    }
}
