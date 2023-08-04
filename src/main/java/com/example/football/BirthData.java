package com.example.football;

import com.google.gson.annotations.SerializedName;

public class BirthData {
    @SerializedName("country")
    public String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BirthData(String country) {
        this.country = country;
    }
}
