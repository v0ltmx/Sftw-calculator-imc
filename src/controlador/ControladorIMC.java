/*
Escola Agrícola de Jundiaí - POO2k19.2
Autores: @Luan Souza
         @Lucas Gabriel
*/
package controlador;

//JFX imports para serem usados logo mais
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;


import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javax.swing.text.DateFormatter;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


import modelo.Usuario;
import persistence.UsuarioDAO;

public class ControladorIMC implements Initializable{
    
    
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private Usuario u;
    
    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    
    @FXML
    private StackPane stack;
    
    enum Sexo {
        MASC,
        FEM
    };
    
    @FXML
    JFXComboBox sexoCad;
    
    ObservableList<Sexo> sexo = FXCollections.observableArrayList();
    
    @FXML
    JFXButton cadastrarButton, voltar;
    
    @FXML
    TextField nomeCad, pesoCad, idadeCad, alturaCad;
    
    @FXML
    JFXDatePicker dataCad;
    
    @FXML
    BorderPane telaCad;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexo.addAll(Sexo.values());
        sexoCad.setItems(sexo);
        
    }
    /*
    @FXML
    private void calcularIMC(){
        if(!pesoCad.getText().isEmpty() && !alturaCad.getText().isEmpty() && dataCad.getValue() != null){
            double peso, altura;
            try{
                peso = Double.parseDouble(pesoCad.getText());
                altura = Double.parseDouble(alturaCad.getText());
            }catch(NumberFormatException ex){
                Util.gerarDialogo("Entrada Invalida", "Os campos Altura e Peso devem receber numeros", stack);
                return;
            }
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            String d = dateFormatter.format(dataCad.getValue());
            
            double imc = u.calcularIMC(peso, altura);
            
            DecimalFormat df = new DecimalFormat("0.##");
        }
    }
    */
    @FXML
    private void cadastrar(){
        if(!nomeCad.getText().isEmpty() &&
            !pesoCad.getText().isEmpty() &&
            !alturaCad.getText().isEmpty() &&
            !idadeCad.getText().isEmpty()
            ){
            
            double peso, altura;
            int idade;
            
            peso = Double.parseDouble(pesoCad.getText());
            altura = Double.parseDouble(alturaCad.getText());
            idade = Integer.parseInt(idadeCad.getText());
            
            Usuario user  = new Usuario(nomeCad.getText(), idade, altura, peso);
            
            if(!usuarios.contains(user)){
                usuarioDao.insertUsuario(user);
            } else {
                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setTitle("Alerta");
                alerta.setHeaderText("Usuário já existe");
                alerta.setContentText("Nome de usuário já existente");
                alerta.showAndWait();
            }
        }/*
        try{
            Parent usuarioTela = FXMLLoader.load(getClass().getResource("/visao/MenuPrincipal.fxml"));
            tela.setCenter(usuarioTela);
        }catch(IOException e){
            e.printStackTrace();
        }*/
    }
    
    @FXML
    private void voltar(ActionEvent event){
        try{
            Parent telaLogin = FXMLLoader.load(getClass().getResource("/visao/MenuPrincipal.fxml"));
            telaCad.setCenter(telaLogin);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
