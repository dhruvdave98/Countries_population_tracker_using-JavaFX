package com.example.javaassignment2;


import com.example.javaassignment2.Models.AllCountries;

public class ApiResponse {
    private Boolean ok;

    private AllCountries body;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public AllCountries getBody() {
        return body;
    }

    public void setBody(AllCountries body) {
        this.body = body;
    }
}
