package ro.se.lab;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ro.se.lab.Log.Log;

public class WindowController {
    @FXML
    private Button testBtn;
    @FXML
    private Label testLabel;

    public void OnTestBtnPressed(javafx.event.ActionEvent actionEvent) {
        testBtn.setDisable(true);
        Log.Info("Info log");
        Log.Error("Error log");
        Log.Debug("Debug log");
        testLabel.setText("You pressed the damm button");
    }
}
