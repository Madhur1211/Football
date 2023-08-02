package com.example.football;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class teamsDirectory {

    @SerializedName("response")
    public List<Team> teams;

    // Other methods if needed

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}