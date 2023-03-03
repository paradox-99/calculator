package sourcefile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application  {
    public void start(Stage stage) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("calculator_interface.fxml"));
            Scene scene = new Scene(root.load());
            scene.setFill(Color.TRANSPARENT);

            // taskbar icon image
            stage.getIcons().add(new Image(getClass().getResourceAsStream("images/Calculator.jpg")));
            stage.setTitle("Calculator"); // taskbar title
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setResizable(false);
            stage.setScene(scene);
            ((MainWindowController)root.getController()).initia(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}