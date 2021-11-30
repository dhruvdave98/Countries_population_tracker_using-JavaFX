package com.example.javaassignment2;

import com.google.gson.annotations.SerializedName;

public class CountryPopulation {

    @SerializedName("country_name")
    private String countryName;

    private int population;

    private int ranking;

    @SerializedName("world_share")
    private double worldShare;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public double getWorldShare() {
        return worldShare;
    }

    public void setWorldShare(double worldShare) {
        this.worldShare = worldShare;
    }
}
