package com.example.football;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiUtility {

    // Method to make a GET request to the API and return the JSON response as a string
    public static String makeGetRequest(String apiUrl, String apiKey) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Method to parse JSON response and process each Team object using Gson library and a forEach loop
    public static List<Team> processJsonResponse(String jsonResponse) {
        Gson gson = new Gson();
        teamsDirectory teamsDir = gson.fromJson(jsonResponse, teamsDirectory.class);

        // Process each Team object
        for (Team team : teamsDir.getTeams()) {
            // Do something with the team, for example, print its name
            System.out.println("Team Name: " + team.getName());
        }
        return null;
    }
}
