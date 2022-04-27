/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Alison
 */
public class AppFX extends Application{
    
    public static Pane TelaPrincipal, TelaCadastroPaciente, TelaCadastroProfissionalSaude, TelaCadastroAtendente, TelaCadastroAdmin;
    static Scene TelaPrincipalScene, TelaCadastroPacientesScene;
    static Stage stage;
    
    public Pane carregarArquivo(String caminho) throws IOException{
    
    Pane pane = FXMLLoader.load(getClass().getResource(caminho));

     return pane;
    }
   
    

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));  
        Scene scene = new Scene(root);
        
        TelaPrincipal = carregarArquivo("../view/TelaPrincipal.fxml");
        TelaCadastroPaciente = carregarArquivo("../view/CadastrarPacientes.fxml");
        TelaCadastroProfissionalSaude = carregarArquivo("../view/CadastrarProfissionalDeSaude.fxml");
        TelaCadastroAtendente = carregarArquivo("../view/CadastroAtendente.fxml");
        TelaCadastroAdmin = carregarArquivo("../view/CadastrarAdministrador.fxml");
        
        TelaPrincipalScene = new Scene(TelaPrincipal);    
        
        
        
        this.stage.setScene(scene);
        this.stage.setTitle("Hospital Universitario");
        this.stage.setResizable(false);
        this.stage.show();
        
    }
    
    
    public static void changeStage(String Tela){
    
        switch(Tela){
            case "TelaPrincipal":
            stage.setScene(TelaPrincipalScene);
            stage.centerOnScreen();
            break;
            default:
             break;
        
        }
        
       
    }
    
    public static Pane retornarPainel (String painel){
    
        switch(painel){
            case "TelaCadastroPacientes":
               return TelaCadastroPaciente;
            case "TelaCadastroProfissionalSaude":
               return TelaCadastroProfissionalSaude;
            case "TelaCadastroAtendente":
               return TelaCadastroAtendente;
               case "TelaCadastroAdmin":
               return TelaCadastroAdmin;
            default:
             break;
            }
        return new Pane();
    }
    
    
    
     public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
}
