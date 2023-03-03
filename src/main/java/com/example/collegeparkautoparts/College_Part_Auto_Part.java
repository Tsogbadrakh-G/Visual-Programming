package com.example.collegeparkautoparts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class College_Part_Auto_Part extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
     TreeItem<Part> root=TreeTableUtil.getModel();
        Label lbl=new Label("College Auto Part");
        Line l1=new Line();
        // Create a TreeTableView with model
        TreeTableView<Part> treeTable = new TreeTableView<Part>(root);
        treeTable.setEditable(true);
        treeTable.setPrefWidth(800);

        // Create the TreeTableColumns
        TreeTableColumn<Part, String>  yearCol =  TreeTableUtil.getyearColumn();
        yearCol.setCellFactory(TextFieldTreeTableCell.<Part>forTreeTableColumn());
        yearCol.setPrefWidth(200);

        TreeTableColumn<Part, String> makeCol =TreeTableUtil.getmakeColumn();
        makeCol.setCellFactory(TextFieldTreeTableCell.<Part>forTreeTableColumn());
        makeCol.setPrefWidth(200);

        TreeTableColumn<Part, String>  modelCol= TreeTableUtil.getmodelColumn();
        modelCol.setPrefWidth(200);
        modelCol.setCellFactory(TextFieldTreeTableCell.<Part>forTreeTableColumn());

        TreeTableColumn<Part ,String> typeCol =  TreeTableUtil.gettypeColumn();
        typeCol.setPrefWidth(200);
        typeCol.setCellFactory(TextFieldTreeTableCell.<Part>forTreeTableColumn());

        TreeTableView.TreeTableViewSelectionModel<Part> selection = treeTable.getSelectionModel();
        selection.setSelectionMode(SelectionMode.MULTIPLE);


        treeTable.getColumns().addAll(yearCol,makeCol,modelCol,typeCol);
        BorderPane container = new BorderPane(treeTable);
        Scene scene=new Scene(container);
        primaryStage.setTitle("treeView Sample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
