package sourcefile3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class cont {
    @FXML
    private TextField number1;

    @FXML
    private TextField number2;

    @FXML
    private TextField resnum1;

    @FXML
    private TextField resnum2;

    @FXML
    void okdone(ActionEvent event) {
        int a = Integer.parseInt(number1.getText());
        int b = Integer.parseInt(number2.getText());

        // if(a<b){
        //     Stage stage = new Stage();
        //     Label lab = new Label("Not valid");
        //     lab.setStyle(" -fx-background-color: white;");
        //     lab.setMinWidth(80);
        //     lab.setMinHeight(50);
        //     Popup pop = new Popup();
        //     pop.getContent().add(lab);
        //     pop.show(stage);
        //     stage.show();
        // }
        // else{
        //     System.out.println("a: "+a);
        //     System.out.println("b: "+b);
        // }
        
        resnum1.setText(String.valueOf(a));
        resnum2.setText(String.valueOf(b));
        
    }
}
