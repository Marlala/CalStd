package sample;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    // further work: add clear button - seems to be working !!
    // add view of numbers adding - done !!
    // change numbers to double? or BigDec - get that to work in copied version of this app ..
    // added the text field to not be editable !!

    @FXML
    private TextField viewResult;
    @FXML
    private Label label;

    private long num1 = 0;
    private String operator ="";
    private boolean start = true;

    private Model model = new Model();

    @FXML
    private void processNum(ActionEvent event) {
        if (start) {
            viewResult.setText("");
            label.setText("");
            start = false;
    }
        String value = ((Button)event.getSource()).getText();
        viewResult.setText(viewResult.getText() + value);
        label.setText(value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            num1 = Long.parseLong(viewResult.getText());
            viewResult.setText("");
            label.setText(value);
        } else {
            if (operator.isEmpty())
                return;

            viewResult.setText(String.valueOf(model.calc(num1, Long.parseLong(viewResult.getText()), operator)));
            operator = "";
            label.setText("Result Ready");
            start = true;
        }
    }
    @FXML
        private void processClear(ActionEvent event) {
            num1 = 0;
            operator = "";
            viewResult.setText("");
            label.setText("");
    }
}