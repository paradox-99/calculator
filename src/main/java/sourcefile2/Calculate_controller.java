package sourcefile2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Calculate_controller {
    @FXML
    private Label numInput;

    @FXML
    private Label result;

    @FXML
    private Button clear;

    @FXML
    private ImageView exit_btn;

    @FXML
    private ImageView minimized_btn;

    @FXML
    private Pane titlePane;

    private double x, y;

    private double num1 = 0;
    private double total = 0;
    private String operator = "";
    private boolean check = true;

    public Double create(double num1, double num2, String operator) {

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                break;
        }
        return 0.0;
    }

    public void number(String number) {
        result.setText(result.getText() + number);
    }

    public void inputNumber(String number) {
        numInput.setText(numInput.getText() + number);
    }

    public void inputOperator(String operator) {
        numInput.setText(numInput.getText() + " " + operator + " ");
    }

    public void computeProcess(ActionEvent event) {
        if (check) {
            result.setText("");
            numInput.setText("");
            check = false;
        }

        Button button = (Button) event.getSource();
        String value = button.getText();
        number(value);
        inputNumber(value);
    }

    public void operatorProcess(ActionEvent event) {
        Button button = (Button) event.getSource();
        String value = button.getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;
            operator = value;
            inputOperator(operator);
            num1 = Double.parseDouble(result.getText());
            result.setText("");

        } else {
            if (operator.isEmpty())
                return;
            double num2 = Double.parseDouble(result.getText());

            total = create(num1, num2, operator);
            result.setText(String.valueOf(total));
            operator = "";
            check = true;
        }

    }

    public void clear(ActionEvent event) {
        if (event.getSource() == clear) {
            result.setText("0");
            numInput.setText("");
        }
    }

    public void topBar(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        exit_btn.setOnMouseClicked(mouseEvent -> stage.close());
        minimized_btn.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }
}
