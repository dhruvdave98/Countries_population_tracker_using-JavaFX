package com.example.javaassignment2;

import com.example.javaassignment2.Models.CountryPopulation;

public class ApiResponseCountryDetails {
    private Boolean ok;

    private CountryPopulation body;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public CountryPopulation getBody() {
        return body;
    }

    public void setBody(CountryPopulation body) {
        this.body = body;
    }
}
