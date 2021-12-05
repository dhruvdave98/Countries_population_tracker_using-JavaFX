package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.ApiResponseCountryDetails;
import com.example.javaassignment2.Models.CountryPopulation;
import com.example.javaassignment2.Utilities.APIUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    public void loadCountryDetails(String countryName) throws IOException, InterruptedException {
        ApiResponseCountryDetails apiResponseCountryDetails = APIUtility.getCountryDetails(countryName);
        CountryPopulation country = apiResponseCountryDetails.getBody();
        countryNameLabel.setText(country.getCountryName());
        populationLabel.setText(String.valueOf(country.getPopulation()));
        rankingLabel.setText(String.valueOf(country.getRanking()));
        worldShareLabel.setText(String.valueOf(country.getWorldShare()));

    }
}
