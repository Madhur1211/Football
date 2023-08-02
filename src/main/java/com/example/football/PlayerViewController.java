package com.example.football;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PlayerViewController {

    @FXML
    private TableView<Player> tableView;

    @FXML
    private TableColumn<Player, Integer> colAge;

    @FXML
    private TableColumn<Player, String> colCountry;

    @FXML
    private TableColumn<Player, String> colFName;

    @FXML
    private TableColumn<Player, String> colFullName;

    @FXML
    private TableColumn<Player, String> colLName;

    public void initialize(){

      /*  colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));


        //fetchDataFromAPI();*/
    }

    public static String makeGetRequest(String apiUrl, String apiKey) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/players?team=33&season=2020"))
                .header("X-RapidAPI-Key", "3dcae264e1mshfddec9c0daf260ep18f802jsnc3a4c65c2db1")
                .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();
        return jsonResponse;
    }

    public static void main(String[] args){
        try {
            String jsonResponse = makeGetRequest("https://api-football-v1.p.rapidapi.com/v3/players?team=33&season=2020", "3dcae264e1mshfddec9c0daf260ep18f802jsnc3a4c65c2db1");
            System.out.println(jsonResponse);

            Gson gson = new Gson();
            PlayerDirectory playerDirectory = gson.fromJson(jsonResponse, PlayerDirectory.class);
            System.out.println(playerDirectory.Players.size());
            for(Player p: playerDirectory.Players){
                System.out.println("First Name: " + p.fName);
                System.out.println("Last Name: " + p.lName);
                System.out.println("Full Name: " + p.fullName);
                System.out.println("Age: " + p.age);
                System.out.println("Country: " + p.country);
                System.out.println("-----------------------");
            }
           /* tableView.getItems().clear();

            colFName.setCellValueFactory(new PropertyValueFactory<>("fName"));
            colLName.setCellValueFactory(new PropertyValueFactory<>("lName"));
            colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
            colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
            colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

            tableView.getItems().addAll(playerDirectory.getPlayers()); */

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

