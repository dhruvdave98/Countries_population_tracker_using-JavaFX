package com.example.javaassignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class AllCountries {

    private String[] countries;
    //ObservableList<String> countries;

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    
    public String toString()
    {
        return String.format("%s",countries);
    }

}
