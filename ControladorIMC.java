
package controlador;

//JFX imports para serem usados logo mais
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDatePicker;


import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javax.swing.text.DateFormatter;

import modelo.Usuario;

public class ControladorIMC implements Initializable{
    
    Usuario u;
    
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
    JFXButton cadastrarButton;
    
    @FXML
    JFXTextArea nomeCad;
    
    @FXML
    JFXTextField pesoCad, alturaCad, idadeCad;
    
    @FXML
    JFXDatePicker dataCad;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sexo.addAll(Sexo.values());
        sexoCad.setItems(sexo);
    }
    
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
}