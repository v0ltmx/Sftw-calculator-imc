/*
Escola Agrícola de Jundiaí - POO2k19.2
Autores: @Luan Souza
         @Lucas Gabriel
*/
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Usuario;


public class ControladorUsuario implements Initializable{
    
    private static String imcAntigo = "IMC Antigo";
    private static String imcAtual = "IMC Atual";
    
    @FXML
    Label nomeuser, imcResult, statusResul;
    
    @FXML
    BarChart graficoIMC;
    
    Stage stageS = new Stage();
    
    @FXML
    BorderPane telaUser;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeuser.setText(ControladorLogin.login);
        imcResult.setText(ControladorLogin.imcResultado);
        statusResul.setText(ControladorLogin.statusResultado);
        gerarGrafico(stageS);
    }
    
    private void gerarGrafico(Stage stage){
    
        stage.setTitle("Grafico IMC");
        final CategoryAxis eixoX = new CategoryAxis();
        final NumberAxis eixoY = new NumberAxis();
        final BarChart<String, Number> barchart = new BarChart<>(eixoX, eixoY);
        barchart.setTitle("Grafico IMC");
        eixoX.setLabel("IMC");
        eixoY.setLabel("Valores");
        
       // if()
        
        XYChart.Series imcPlotar = new XYChart.Series();
        imcPlotar.setName("Resultado do IMC");
        imcPlotar.getData().add(new XYChart.Data(imcAtual, ControladorLogin.imcResultadoDouble));
        
        Scene scene  = new Scene(barchart,500,300);
        barchart.getData().addAll(imcPlotar);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void novaConsulta(ActionEvent event){
        try{
            Parent telaNovaConsulta = FXMLLoader.load(getClass().getResource("/visao/NovaConsulta.fxml"));
            telaUser.setCenter(telaNovaConsulta);
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
