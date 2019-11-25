
package controlador;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Util {
    
    public static void gerarDialogo(String title, String content, StackPane stack) {
        Text titulo = new Text();
        titulo.setText(title);
        titulo.setFont(Font.font("System", FontWeight.BOLD, 16));

        JFXDialogLayout dialogContent = new JFXDialogLayout();
        dialogContent.setHeading(titulo);
        dialogContent.setBody(new Text(content));

        JFXButton close = new JFXButton("Fechar");
        close.setButtonType(JFXButton.ButtonType.FLAT);
        close.setStyle("-fx-background-color:  #4059a9; -fx-text-fill: white;");

        dialogContent.setActions(close);
        JFXDialog dialog = new JFXDialog(stack, dialogContent, JFXDialog.DialogTransition.CENTER);
        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent __) {
                dialog.close();
            }
        });
        dialog.show();
    }
}
/*
private StringConverter<LocalDate> data(){
        
        String pattern = "yyyy-MM-dd";
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>(){
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if(date != null){
                    return formatar.format(date);
                }else{
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty()){
                    return LocalDate.parse(string,formatar);
                }else{
                    return null;
                }
            }
            
        };
        return converter;
    }/*
