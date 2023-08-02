package com.example.football;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Type;
import java.util.List;

public class TeamsViewController {

    @FXML
    private Button switchScene;

    @FXML
    private TableView<Team> tableView;

    @FXML
    private TableColumn<Team, String> teamNameColumn;

    public void initialize() {
        // Bind the team name to the table column
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        fetchTeamDataFromAPI();
    }

    public void fetchTeamDataFromAPI() {
        try {
            // Fetch the JSON string from the API using ApiUtility
            String jsonstring = ApiUtility.makeGetRequest("https://api-football-v1.p.rapidapi.com/v3/teams/countries", "3dcae264e1mshfddec9c0daf260ep18f802jsnc3a4c65c2db1");

            // Parse the JSON string using Gson into a teamsDirectory object
            Gson gson = new Gson();
            teamsDirectory teamsDirectory = gson.fromJson(jsonstring, teamsDirectory.class);

            // Assuming you have a TableView and a TableColumn named tableView and teamNameColumn, respectively
            tableView.getItems().clear(); // Clear the existing items in the TableView

            // Create a TableColumn to display team names
            TableColumn<Team, String> teamNameColumn = new TableColumn<>("Team Name");
            teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            // Add the teamNameColumn to the TableView
            tableView.getColumns().clear(); // Clear existing columns
            tableView.getColumns().add(teamNameColumn);

            // Add the teams to the TableView
            tableView.getItems().addAll(teamsDirectory.getTeams());
        } catch (Exception e) {
            // Handle exceptions more gracefully
            e.printStackTrace();
        }
    }



}
