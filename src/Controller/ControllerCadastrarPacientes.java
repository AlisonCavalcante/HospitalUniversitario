/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import JpaUtil.JpaUtil;
import br.com.beans.Cidade;
import br.com.beans.Endereco;
import br.com.beans.Estado;
import br.com.beans.Paciente;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alison
 */
public class ControllerCadastrarPacientes implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField textFNome;

    @FXML
    private TextField textFCpf;

    @FXML
    private TextField textFemail;

    @FXML
    private TextField textFIdade;
    
    @FXML
    private DatePicker dataNascimento;

    @FXML
    private TextField textFAlergias;

    @FXML
    private TextField textFRh;

    @FXML
    private TextField TextFTipoSanguineo;

    @FXML
    private DatePicker dataFalecimento;

    @FXML
    private RadioButton doadorOrgaos;
    
    @FXML
    private Button salvarButton;
    
    @FXML
    private Button cadastrarEnderecoButton;

    @FXML
    private TextField textFEndereco;
   
    @FXML
    private TextField textFBuscarCidade;

    @FXML
    private Button buttonBuscarCidade;
    
     @FXML
    private TextField textFLogradouro;

    @FXML
    private TextField textFNumero;

    @FXML
    private TextField textFCep;

    @FXML
    private TextField textFCidadeNome;

    @FXML
    private ComboBox<String> comboBoxUF;
    
    @FXML
    private ComboBox<String> comboBox_Estados;
    
    @FXML
    private ComboBox<String> combo_sexo;
    
    @FXML
    private TextField textFBairro;
    
    private IcoreFacade icoreFacade;
    private Paciente paciente;
    private  List<Endereco> enderecos = new ArrayList<>();
    private Cidade cidade;
    private Estado estado;
    @FXML
    void onButton(ActionEvent event) {
       
        if(event.getSource() == salvarButton ){
             
            try {
            String uf = comboBoxUF.getSelectionModel().getSelectedItem();
            String estados = comboBox_Estados.getSelectionModel().getSelectedItem();
            String sexo = combo_sexo.getSelectionModel().getSelectedItem();
            estado = icoreFacade.buscarEstadoPornome(estados, JpaUtil.fabricaDeConexoes());
            estado.setUf(uf);
            icoreFacade.salvarEstado(estado, JpaUtil.fabricaDeConexoes());
            
            
            cidade.setNome(textFCidadeNome.getText());
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
   
                
                
                paciente = new Paciente();
                paciente.setNome(textFNome.getText());
                paciente.setCpf(textFCpf.getText());
                paciente.setAlergias(textFAlergias.getText());
                paciente.setDataNascimento(dataSelecionada(dataNascimento));
                paciente.setEmail(textFemail.getText());
                paciente.setSexo(sexo);
                paciente.setIdade(20);
                paciente.setEnderecos(enderecos);
                paciente.setTipaguem_sanguinea(TextFTipoSanguineo.getText());
                paciente.setFator_rh(textFRh.getText());
                icoreFacade.salvarPaciente(paciente, JpaUtil.fabricaDeConexoes());
            } catch (Exception ex) {
                ex.printStackTrace();
                Alertas.AlertaErro("Erro ao Salvar");
            }   
            
            Alertas.AlertaSucesso("Paciente Salvo com Sucesso!");
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
		comboBoxUF.setItems(combo_UF);
                ObservableList<String> combo_Estados = FXCollections.observableArrayList("","Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espiríto Santo",
				"Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rido de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraíma", "Santa Catarina", "São Paulo",
				"Sergipe", "Tocantis");
                comboBox_Estados.setItems(combo_Estados);
                ObservableList<String> comboBox_sexo = FXCollections.observableArrayList("","Feminino","Masculino");
                combo_sexo.setItems(comboBox_sexo);
	}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        icoreFacade = CoreFacade.getInstance();
        carregarComboBox();
    }    
    
}
