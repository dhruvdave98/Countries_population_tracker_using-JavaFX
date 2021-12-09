package com.example.javaassignment2;

import com.example.javaassignment2.Controllers.CountryDetailsViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    /**
     * This method is used to change the scene from 1st scene to 2nd scene
     * @param event
     * @param fxmlFile
     * @param countryName
     * @throws IOException
     * @throws InterruptedException
     */
    public static void changeScenes(ActionEvent event, String fxmlFile, String countryName) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        CountryDetailsViewController controller = fxmlLoader.getController();
        controller.loadCountryDetails(countryName);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Country Details");
        stage.setScene(scene);
        stage.show();
    }
}
