package com.example.football;

import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("firstname")
    public String fName;
    @SerializedName("lastname")
    public String lName;
    @SerializedName("name")
    public String fullName;
    @SerializedName("age")
    public int age;
    @SerializedName("Country")
    public String country;

    public Player(String fName, String lName, String fullName, int age, String country) {
        this.fName = fName;
        this.lName = lName;
        this.fullName = fullName;
        this.age = age;
        this.country = country;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
