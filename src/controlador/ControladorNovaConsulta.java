/*
Escola Agrícola de Jundiaí - POO2k19.2
Autores: @Luan Souza
         @Lucas Gabriel
         Está incompleta a implementação...
*/
package controlador;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modelo.Usuario;
import persistence.UsuarioDAO;

/**
 *
 * @author Aluno
 */
public class ControladorNovaConsulta implements Initializable{

    Usuario user = null;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    
    @FXML
    TextField novoPeso, novaAltura;
    
    @FXML
    JFXButton novoIMC;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    @FXML
    private void novoIMC(ActionEvent event){
        if(!novoPeso.getText().isEmpty() &&
           !novaAltura.getText().isEmpty()){
            
            usuarioDao.updateAntigoIMC(user);
            
            double novoPesoUser, novaAlturaUser;
            
            novoPesoUser = Double.parseDouble(novoPeso.getText());
            user.setPeso(novoPesoUser);
            
            novaAlturaUser = Double.parseDouble(novaAltura.getText());
            user.setAltura(novaAlturaUser);
            
            usuarioDao.updateIMC(user);
        }
    }
}
