package com.example.football;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class SceneManager {
    static public void changeScene(ActionEvent event, String fxmlName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load(), 520, 540);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Driving License Data");
        stage.setScene(scene);
        stage.show();
    }
}
