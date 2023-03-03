package com.example.collegeparkautoparts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CollegePark extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        BorderPane root = FXMLLoader.load(getClass().getResource("CollegePark.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setTitle("treeView Sample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
