package com.example.javaassignment2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String countryName = "Mexico";
        countryName = countryName.trim().replace(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://world-population.p.rapidapi.com/population?country_name="+countryName))
                .header("x-rapidapi-host", "world-population.p.rapidapi.com")
                .header("x-rapidapi-key", "5a22e250e7msh5ef0a18e291df53p16a835jsn7951646be950")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

}
