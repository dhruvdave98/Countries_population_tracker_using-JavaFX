package com.example.javaassignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("country-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Select Country");
        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon.png")));
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}