
package controlador;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControladorIMC implements Initializable{

    enum Sexos {
        MASC,
        FEM
    };
   
    
    @FXML
    JFXComboBox sexoCad;
    
    ObservableList<Sexos> sexo = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sexo.addAll(Sexos.values());
        sexoCad.setItems(sexo);
    }
}