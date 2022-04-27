/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import JpaUtil.JpaUtil;
import br.com.beans.Administrador;
import br.com.beans.Cidade;
import br.com.beans.Endereco;
import br.com.beans.Estado;
import br.com.facade.CoreFacade;
import br.com.facade.IcoreFacade;
import br.com.view.Alertas;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alison
 */
public class ControllerCadastrarAdministrador implements Initializable {

      @FXML
    private TextField textFNome;

    @FXML
    private TextField textFCpf;

    @FXML
    private TextField textFEmail;

    @FXML
    private ComboBox<String> combo_sexo;

    @FXML
    private DatePicker dataNascimento;

    @FXML
    private TextField textFBairro;

    @FXML
    private TextField textFNumero;

    @FXML
    private TextField textFLogradouro;

    @FXML
    private TextField textFSalario;

    @FXML
    private ComboBox<String> combo_estados;

    @FXML
    private ComboBox<String> combo_uf;

    @FXML
    private Button salvarButton;
    @FXML
    private TextField textFNomeCidade;
    @FXML
    private TextField textFCep;
    @FXML
    private TextField textFCarga_horaria;
    
    private IcoreFacade icoreFacade;
    private Administrador administrador;
    private Estado estado;
    private Cidade cidade;
    private  List<Endereco> enderecos = new ArrayList<>();
    @FXML
    void onButton(ActionEvent event) {
        cidade = new Cidade();
        estado = new Estado();
        String sexo = combo_sexo.getSelectionModel().getSelectedItem();
        String estados = combo_estados.getSelectionModel().getSelectedItem();
        String uf = combo_uf.getSelectionModel().getSelectedItem();
        if(event.getSource() == salvarButton){
            
            estado.setNome(estados);
            estado.setUf(uf);
            try {
                icoreFacade.salvarEstado(estado, JpaUtil.fabricaDeConexoes());
                cidade.setNome(textFNomeCidade.getText());
            cidade.setEstado(estado);
            icoreFacade.salvarCidade(cidade, JpaUtil.fabricaDeConexoes());
            
            Endereco end = new Endereco();
            end.setBairro(textFBairro.getText());
            end.setLogradouro(textFLogradouro.getText());
            int numero = Integer.parseInt(textFNumero.getText());
            int cep = Integer.parseInt(textFCep.getText());
            end.setNumero(numero);
            end.setCep(cep);
            end.setCidade(cidade);     
            icoreFacade.salvarEndereco(end, JpaUtil.fabricaDeConexoes());
            enderecos.add(end);
            
            
            administrador = new Administrador();
            administrador.setNome(textFNome.getText());
            administrador.setCpf(textFCpf.getText());
            administrador.setSexo(sexo);
            administrador.setEmail(textFEmail.getText());
            float salario = Float.parseFloat(textFSalario.getText());
            administrador.setSalario(salario);
            administrador.setDataNascimento(dataSelecionada(dataNascimento));
            Double carga_horaria = Double.parseDouble(textFCarga_horaria.getText());
            administrador.setCarga_horaria(carga_horaria);
            administrador.setEnderecos(enderecos);
            icoreFacade.salvarAdministrador(administrador, JpaUtil.fabricaDeConexoes());
            
            } catch (Exception ex) {
                Logger.getLogger(ControllerCadastrarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Alertas.AlertaSucesso("Administrador Salvo com Sucesso!");
            
        
        }
    }
     private Date dataSelecionada(DatePicker data) {
		LocalDateTime time = data.getValue().atStartOfDay();
		return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }
    public void carregarComboBox() {

		ObservableList<String> combo_UF = FXCollections.observableArrayList("","AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES",
				"GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP",
				"SE", "TO");
		combo_uf.setItems(combo_UF);
                ObservableList<String> combo_Estados = FXCollections.observableArrayList("","Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espiríto Santo",
				"Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rido de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraíma", "Santa Catarina", "São Paulo",
				"Sergipe", "Tocantis");
                combo_estados.setItems(combo_Estados);
                ObservableList<String> comboBox_sexo = FXCollections.observableArrayList("","Feminino","Masculino");
                combo_sexo.setItems(comboBox_sexo);
	}
    
    public void initialize(URL url, ResourceBundle rb) {
        icoreFacade = CoreFacade.getInstance();
        carregarComboBox();
    }    
    
}
