package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.ApiResponseCountryDetails;
import com.example.javaassignment2.Main;
import com.example.javaassignment2.Models.CountryPopulation;
import com.example.javaassignment2.Utilities.APIUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CountryDetailsViewController implements Initializable {

    @FXML
    private Label countryNameLabel;

    @FXML
    private Label populationLabel;

    @FXML
    private Label rankingLabel;

    @FXML
    private Label worldShareLabel;

    @FXML
    private Button returnToCountries;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadCountryDetails("India");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method loads the country details into the second scene
     * @param countryName
     * @throws IOException
     * @throws InterruptedException
     */
    public void loadCountryDetails(String countryName) throws IOException, InterruptedException {
        ApiResponseCountryDetails apiResponseCountryDetails = APIUtility.getCountryDetails(countryName);
        CountryPopulation country = apiResponseCountryDetails.getBody();
        countryNameLabel.setText(country.getCountryName());
        populationLabel.setText(String.valueOf(country.getPopulation()));
        rankingLabel.setText(String.valueOf(country.getRanking()));
        worldShareLabel.setText(String.valueOf(country.getWorldShare()));
    }

    /**
     * This method is used to redirect to the first scene
     * @param event
     * @throws IOException
     */
    public void returnToCountries(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("country-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
