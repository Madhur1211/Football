package com.example.football;

import com.google.gson.Gson;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PlayerViewController {

    @FXML
    private Button btTeam;

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

    public void initialize() {
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colCountry.setCellValueFactory(cellData -> {
            Player player = cellData.getValue();
            String country = player.getBirthData().getCountry();
            return new SimpleStringProperty(country);
        });

        fetchDataFromAPI();
    }

    private void fetchDataFromAPI() {
        try {
            String jsonResponse = makeGetRequest("https://api-football-v1.p.rapidapi.com/v3/players?team=33&season=2020", "3dcae264e1mshfddec9c0daf260ep18f802jsnc3a4c65c2db1");

            Gson gson = new Gson();
            PlayerDirectory playerDirectory = gson.fromJson(jsonResponse, PlayerDirectory.class);
            List<PlayerData> playerDataList = playerDirectory.getPlayerData();
            if (playerDataList != null && !playerDataList.isEmpty()) {
                for (PlayerData playerData : playerDataList) {
                    Player player = playerData.getPlayer();
                    if (player != null) {
                        tableView.getItems().add(player);
                    }
                }
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

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

    @FXML
    public void changeViewToTeams(ActionEvent event) throws IOException {
        // Switch to the TableView scene when the button is clicked
        SceneManager.changeScene(event, "teamView.fxml");
    }


}
