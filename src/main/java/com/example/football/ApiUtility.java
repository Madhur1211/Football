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
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/teams/countries"))
                .header("X-RapidAPI-Key", "3dcae264e1mshfddec9c0daf260ep18f802jsnc3a4c65c2db1")
                .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = response.body();
        return jsonString;
    }
}
