package com.example.football;

import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Team {
    @SerializedName("name")
    public String name;

    // Constructor
    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public StringProperty teamNameProperty() {
        return new SimpleStringProperty(name);
    }
}
