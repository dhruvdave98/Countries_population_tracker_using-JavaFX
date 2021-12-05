package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.ApiResponse;
import com.example.javaassignment2.SceneChanger;
import com.example.javaassignment2.Utilities.APIUtility;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
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

        moreDetailsButton.disableProperty().bind(
                Bindings.isNull(countryListView.getSelectionModel().selectedItemProperty())
        );
    }

    @FXML
    private void getCountryDetails(ActionEvent event) throws IOException, InterruptedException {
        String countryName = countryListView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event, "country-details-view.fxml", countryName);
    }
}
