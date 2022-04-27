/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import javafx.scene.control.Alert;

/**
 *
 * @author Alison
 */
public class Alertas {
    
    static Alert alerta;
    
    public static void AlertaErro(String mensagem){
    
        alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(mensagem);
            alerta.showAndWait();
        
        
    }
    
    public static void AlertaSucesso(String mensagem){
    
        alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sucesso");
            alerta.setHeaderText(mensagem);
            alerta.showAndWait();
        
        
    }
    
}
