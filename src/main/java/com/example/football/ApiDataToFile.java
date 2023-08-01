package com.example.football;

import java.io.FileWriter;
import java.io.IOException;

public class ApiDataToFile {
    public static void main(String[] args) {
        String apiUrl = "https://api-football-v1.p.rapidapi.com/v3/teams/countries";
        String apiKey = "3dcae264e1mshfddec9c0daf260ep18f802jsnc3a4c65c2db1";

        try {
            String jsonResponse = ApiUtility.makeGetRequest(apiUrl, apiKey);

            // Save the JSON response to a .json file
            try (FileWriter fileWriter = new FileWriter("teamsData.json")) {
                fileWriter.write(jsonResponse);
            }

            System.out.println("JSON data saved to teamsData.json successfully!");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
