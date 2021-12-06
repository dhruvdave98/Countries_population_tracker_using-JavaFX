package com.example.javaassignment2.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;


public class AllCountries {

    private String[] countries;

    public String[] getCountries() {
        return countries;
    }

    public String[] getSortedCountry()
    {
        Arrays.sort(countries);
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
