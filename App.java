package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        URL fxmlURL = getClass().getClassLoader().getResource("network_pack.fxml");
        GridPane root =FXMLLoader.load(fxmlURL);

        Scene scene = new Scene(root, 800, 400);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}