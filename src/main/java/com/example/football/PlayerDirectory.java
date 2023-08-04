package com.example.football;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayerDirectory {
    @SerializedName("response")
    public List<PlayerData> playerData;

    public List<PlayerData> getPlayerData() {
        return playerData;
    }

    public void setPlayerData(List<PlayerData> playerData) {
        this.playerData = playerData;
    }
}
