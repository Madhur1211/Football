package com.example.football;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerDirectory {
    @SerializedName("response")
    public List<Player> Players;

    public List<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(List<Player> players) {
        Players = players;
    }
}
