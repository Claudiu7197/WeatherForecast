package ro.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.se.lab.Input.FileRead;

import java.io.IOException;

public class WeatherForecast extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws IOException {
        FileRead.Read();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main_window.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        theStage.setScene(scene);
        theStage.setTitle("Weather forecast");
        theStage.centerOnScreen();
        theStage.setResizable(false);
        theStage.show();
    }
}
