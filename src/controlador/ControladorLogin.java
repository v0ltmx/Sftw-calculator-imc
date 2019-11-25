
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ControladorLogin implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    

    @FXML
    AnchorPane telaLogar;
    
    @FXML
    JFXButton cadstrarBtn, entrarLog;
    
    @FXML
    JFXTextArea nomeLog;
    
    private void chamarCadastro(){
        try{
            Parent cadastroTela = FXMLLoader.load(getClass().getResource("/visao/TelaCadastro.fxml"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}