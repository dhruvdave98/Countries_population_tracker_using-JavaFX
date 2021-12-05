package com.example.javaassignment2.Utilities;

import com.example.javaassignment2.ApiResponse;
import com.example.javaassignment2.ApiResponseCountryDetails;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APIUtility {
    public static ApiResponse getAllCountriesFromOMDB() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://world-population.p.rapidapi.com/allcountriesname"))
                .header("x-rapidapi-host", "world-population.p.rapidapi.com")
                .header("x-rapidapi-key", "5a22e250e7msh5ef0a18e291df53p16a835jsn7951646be950")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body();

        Gson gson = new Gson();
        ApiResponse apiResponse = null;


        try{
            apiResponse = gson.fromJson(jsonString, ApiResponse.class);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return apiResponse;
    }

    public static ApiResponseCountryDetails getCountryDetails(String countryName) throws IOException, InterruptedException {
        countryName = countryName.trim().replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://world-population.p.rapidapi.com/population?country_name="+countryName))
                .header("x-rapidapi-host", "world-population.p.rapidapi.com")
                .header("x-rapidapi-key", "5a22e250e7msh5ef0a18e291df53p16a835jsn7951646be950")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = response.body();

        Gson gson = new Gson();
        return gson.fromJson(jsonString, ApiResponseCountryDetails.class);
    }
}
