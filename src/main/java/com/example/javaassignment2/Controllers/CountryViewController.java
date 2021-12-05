package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.ApiResponse;
import com.example.javaassignment2.Utilities.APIUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CountryViewController implements Initializable {

    @FXML
    private ListView<String> countryListView;

    @FXML
    private Button moreDetailsButton;

    @FXML
    private Label msgLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApiResponse apiResponse = null;
        try {
            apiResponse = APIUtility.getAllCountriesFromOMDB();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countryListView.getItems().addAll(apiResponse.getBody().getCountries());
    }
}
