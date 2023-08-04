package com.example.football;

import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("firstname")
    public String firstName;
    @SerializedName("lastname")
    public String lastName;
    @SerializedName("name")
    public String fullName;
    @SerializedName("age")
    public int age;
    @SerializedName("birth")
    public BirthData birthData;

    public Player(String firstName, String lastName, String fullName, int age, BirthData birthData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.age = age;
        this.birthData = birthData;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public BirthData getBirthData() {
        return birthData;
    }

    public void setBirthData(BirthData birthData) {
        this.birthData = birthData;
    }
}