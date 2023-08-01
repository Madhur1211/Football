module com.example.football {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.football to javafx.fxml;
    exports com.example.football;
}