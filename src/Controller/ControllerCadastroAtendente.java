/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import JpaUtil.JpaUtil;
import br.com.beans.Atendente;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Alison
 */
public class ControllerCadastroAtendente implements Initializable {

    @FXML
    private AnchorPane painelCadastroDePaciente;

    @FXML
    private TextField textFNome;

    @FXML
    private TextField textFCpf;

    @FXML
    private TextField textFEmail;

    @FXML
    private DatePicker dataNascimento;

    @FXML
    private TextField textFSexo;

    @FXML
    private TextField textFBairro;

    @FXML
    private TextField textFLogradouro;

    @FXML
    private TextField TextFNumero;

    @FXML
    private TextField textFCep;

    @FXML
    private TextField testFCidadeNome;

    @FXML
    private ComboBox<String> comboBox_Estados;

    @FXML
    private Button salvarButton;

    @FXML
    private TextField textFSalario;

    @FXML
    private Button buttonBuscarCidade;

    @FXML
    private ComboBox<String> comboBoxUf;
   

    private IcoreFacade icoreFacade;
    private Atendente atendente;
    private List<Endereco> enderecos = new ArrayList<>();
    private Cidade cidade;
    private Estado estado;
    
    @FXML
    void onButton(ActionEvent event) {
        cidade = new Cidade();
        if(event.getSource() == buttonBuscarCidade){
        
            try {
                List<Cidade> cidades;
                cidades =icoreFacade.listarCidadePornome(testFCidadeNome.getText(), JpaUtil.fabricaDeConexoes());
                
            
            } catch (Exception ex) {
                Logger.getLogger(ControllerCadastroAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        
        if(event.getSource() == salvarButton){
            String uf = comboBoxUf.getSelectionModel().getSelectedItem();
		
            String estados = comboBox_Estados.getSelectionModel().getSelectedItem();
            
            try {
            estado = new Estado();
            estado.setNome(estados);
            estado.setUf(uf);
            icoreFacade.salvarEstado(estado, JpaUtil.fabricaDeConexoes());
            
            
            cidade.setNome(testFCidadeNome.getText());
            cidade.setEstado(estado);
            icoreFacade.salvarCidade(cidade, JpaUtil.fabricaDeConexoes());
            
            Endereco end = new Endereco();
            end.setBairro(textFBairro.getText());
            end.setLogradouro(textFLogradouro.getText());
            int numero = Integer.parseInt(TextFNumero.getText());
            int cep = Integer.parseInt(textFCep.getText());
            end.setNumero(numero);
            end.setCep(cep);
            end.setCidade(cidade);     
            icoreFacade.salvarEndereco(end, JpaUtil.fabricaDeConexoes());
            enderecos.add(end);
            
            atendente = new Atendente();
            atendente.setNome(textFNome.getText());
            atendente.setCpf(textFCpf.getText());
            atendente.setSexo(textFSexo.getText());
            atendente.setEnderecos(enderecos);
            float salario = Float.parseFloat(textFSalario.getText());
            atendente.setSalario(salario);
            atendente.setDataNascimento(dataSelecionada(dataNascimento));
            icoreFacade.salvarAtendente(atendente,JpaUtil.fabricaDeConexoes());
            
            } catch (Exception ex) {
                Logger.getLogger(ControllerCadastroAtendente.class.getName()).log(Level.SEVERE, null, ex);
            }
                       
            Alertas.AlertaSucesso("Salvo com Sucesso");
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
		comboBoxUf.setItems(combo_UF);
                ObservableList<String> combo_Estados = FXCollections.observableArrayList("","Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espiríto Santo",
				"Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rido de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraíma", "Santa Catarina", "São Paulo",
				"Sergipe", "Tocantis");
                comboBox_Estados.setItems(combo_Estados);
	}
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        icoreFacade = CoreFacade.getInstance();
       carregarComboBox();
    }

    
}
