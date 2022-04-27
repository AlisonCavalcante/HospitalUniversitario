/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import br.com.beans.Especializacao;
import br.com.beans.ProfissionalDeSaude;
import br.com.facade.CoreFacade;
import br.com.facade.IcoreFacade;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Alison
 */
public class ControllerCadastrarProfissionalDeSaude implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TextField TextFNome;

    @FXML
    private TextField textFCpf;

    @FXML
    private TextField textFEmail;

    @FXML
    private DatePicker dataNascimento;

    @FXML
    private TextField textFTipo;

    @FXML
    private TextField textFSalario;

    @FXML
    private TextField textFCargaHoraria;

    @FXML
    private Button salvarButton;

    @FXML
    private ComboBox<String> combo_sexo;

    @FXML
    private TableView<Especializacao> tableViewEspecializacao;

    @FXML
    private TableColumn<Especializacao, String> colunaConselho;

    @FXML
    private TableColumn<Especializacao,String> colunaTipo;

    @FXML
    private TableColumn<Especializacao, Float> colunaValor;
    
    @FXML
    private TextField textFBairro;

    @FXML
    private TextField textFLogradouro;

    @FXML
    private TextField textFCep;

    @FXML
    private TextField textFNumero;

    @FXML
    private TextField textFCidadeNome;

    @FXML
    private ComboBox<String> combo_uf;

    @FXML
    private ComboBox<?> combo_especializacao;
    
    @FXML
    private ComboBox<String> combo_estados;
    @FXML
    private Button salvarEspecializacao;
    
    private List<Especializacao> especializacoesTableView = new ArrayList<>();
    private ObservableList<Especializacao> observableListEspecializacao;
    List<Especializacao> especializacoes=new ArrayList<>();
    private IcoreFacade icoreFacade;
    private ProfissionalDeSaude profissionalDeSaude;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        icoreFacade = CoreFacade.getInstance();
        carregarTableViewEspecializacao();
        
        
        
    }    
    
    public void carregarTableViewEspecializacao(){
    
         try {
             colunaConselho.setCellValueFactory(new PropertyValueFactory<>("conselho"));
             colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
             colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
             
             especializacoesTableView = icoreFacade.listarEspecializacaos(JpaUtil.JpaUtil.fabricaDeConexoes());
             
             observableListEspecializacao = FXCollections.observableArrayList(especializacoesTableView);
             
             tableViewEspecializacao.setItems(observableListEspecializacao);
             
         } catch (Exception ex) {
             Logger.getLogger(ControllerCadastrarProfissionalDeSaude.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public Especializacao salvarItemTableViewEspecializacao(){
    
        Especializacao especializacao = tableViewEspecializacao.getSelectionModel().getSelectedItem();
        
        return especializacao;
    }
    
    
    
    
    @FXML
    void onButton(ActionEvent event) {
              
        if(event.getSource() == salvarEspecializacao){
            especializacoes.add(salvarItemTableViewEspecializacao());
            
            
        }
        if(event.getSource() == salvarButton){
        
        
        
        
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
    
    
}
