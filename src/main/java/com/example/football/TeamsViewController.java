package com.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.util.List;

public class TeamsViewController {

    @FXML
    private TableView<Team> tableView;

    @FXML
    private TableColumn<Team, String> teamNameColumn;

    public void initialize() {
        // Bind the team name to the table column
        teamNameColumn.setCellValueFactory(data -> data.getValue().teamNameProperty());

        fetchTeamDataFromAPI();
    }

    private void fetchTeamDataFromAPI() {
        try {
            String apiUrl = "https://api-football-v1.p.rapidapi.com/v3/teams/countries";
            String apiKey = "3dcae264e1mshfddec9c0daf260ep18f802jsnc3a4c65c2db1";

            String jsonResponse = ApiUtility.makeGetRequest(apiUrl, apiKey);

            List<Team> teamData = ApiUtility.processJsonResponse(jsonResponse);

            tableView.getItems().addAll(teamData);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Handle API request or JSON parsing errors
        }
    }
}
