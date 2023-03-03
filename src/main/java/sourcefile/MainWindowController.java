package sourcefile;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private Pane titlePane;

    @FXML
    private ImageView btnExit;

    @FXML
    private ImageView btnMinimize;
    
    @FXML
    private Label result;

    private double x,y;

    public void initia(Stage stage){
        titlePane.setOnMousePressed(mouseEvent ->{
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });
        
        titlePane.setOnMouseDragged(mouseEvent ->{
            stage.setX(mouseEvent.getScreenX()- x);
            stage.setY(mouseEvent.getScreenY()- y);
        });

        btnExit.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("b", ""));
        result.setText(Double.parseDouble(result.getText())==0?String.valueOf((double)value):
        String.valueOf(Double.parseDouble(result.getText())*10+value));
    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        
    }
}