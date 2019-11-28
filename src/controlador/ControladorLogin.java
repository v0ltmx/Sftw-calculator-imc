/*
Escola Agrícola de Jundiaí - POO2k19.2
Autores: @Luan Souza
         @Lucas Gabriel
*/
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import modelo.Usuario;
import persistence.UsuarioDAO;

public class ControladorLogin implements Initializable{
    
    UsuarioDAO usuarioDao = new UsuarioDAO();
    Usuario usuario;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    

    @FXML
    BorderPane tela;
    
    @FXML
    AnchorPane telaLogar;
    
    @FXML
    JFXButton cadstrarBtn, entrarLog;
    
    @FXML
    TextField logarCad;
    
    static String login;
    static String imcResultado;
    static Double imcResultadoDouble;
    static String statusResultado;
    
    
    @FXML
    private void chamarCadastro(){
        try{
            Parent cadastroTela = FXMLLoader.load(getClass().getResource("/visao/TelaCadastro.fxml"));
            
            tela.setCenter(cadastroTela);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void logar(ActionEvent event){
        Boolean ativacao = false;
        if(!logarCad.getText().isEmpty()){
            System.out.println(logarCad.getText());
            login = logarCad.getText().toUpperCase();
            usuario = usuarioDao.selectUsuario(login);
            imcResultado = Double.toString(usuario.calcularIMC(usuario.getPeso(), usuario.getAltura()));
            imcResultadoDouble = usuario.calcularIMC(usuario.getPeso(), usuario.getAltura());
            statusResultado = usuario.verificaIMC(usuario.calcularIMC(usuario.getPeso(), usuario.getAltura()));
            if(usuario.getNome().equals(logarCad.getText().toUpperCase())){
                ativacao = true;
            }
            if(ativacao){
                try{
                    Parent usuarioTela = FXMLLoader.load(getClass().getResource("/visao/TelaUsuario.fxml"));
                    tela.setCenter(usuarioTela);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("TA VAZIO");
        }
    }
    
}
