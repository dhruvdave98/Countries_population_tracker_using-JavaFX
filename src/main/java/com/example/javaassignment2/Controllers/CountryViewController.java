package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.AllCountries;
import com.example.javaassignment2.ApiResponse;
import com.example.javaassignment2.Utilities.APIUtility;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class CountryViewController {

    @FXML
    private ListView<String> countryListView;

    @FXML
    private Button moreDetailsButton;

    @FXML
    private Label msgLabel;

    @FXML
    private void getCountryLoaded() throws IOException, InterruptedException {
        ApiResponse apiResponse = APIUtility.getAllCountriesFromOMDB();

        countryListView.getItems().addAll(apiResponse.getBody().getCountries());
    }

}
