package com.example.collegeparkautoparts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TreeTableUtil
{

   static Image rootI;

    void  initialize() throws IOException {
        rootI=new Image(getClass().getResource("ROOT.png").openStream());
    }

    public static  TreeItem<Part>  getModel() {
        ObservableList<Part> parts = FXCollections.observableArrayList();

        parts.add(new Part("2002", "Ford",
                "Escort SE L4 2.0", "Engine Electrical"
        ));
        parts.add(new Part("2006", "Dodge",
                "Caravan SE L4 2.4", "Cooling System"));
        parts.add(new Part("2000", "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System"));
        parts.add( new Part( "2002", "Honda",
                "Civic 1.7 EX 4DR", "Exhaust"));
        parts.add(new Part( "1996", "Buick",
                "Regal Custom V6 3.8", "Fuel Injection"));
        parts.add(  new Part( "2004", "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle"));
        parts.add ( new Part( "2001", "Ford",
                "Taurus LX V6 3.0", "Fuel Injection"));
        parts.add( new Part( "1999", "Jeep",
                "Wrangler Sahara", "Air Intake"));
        parts.add( new Part( "1998", "Honda",
                "Accord 2.3 LX 4DR", "Air Intake"));
        parts.add( new Part( "2006", "Kia",
                "Rio 1.6DOHC16V 4-DR", "Cooling System"));
        parts.add( new Part( "2000", "Honda",
                "Civic 1.6 EX 4DR", "Suspension"));
        parts.add(new Part("2003", "Chevrolet",
                "Monte Carlo LS V6 3.4", "Fuel Injection"
        ));
        ObservableList<TreeItem<Part>> items=FXCollections.observableArrayList();
      for (Part p:parts){
           items.add(new TreeItem<Part>(p));
      }
        TreeItem<Part> root=new TreeItem<>(new Part("College Park Auto-Parts","","","")
        ,new ImageView(rootI));

        ObservableList<TreeItem<Part>> dates=FXCollections.observableArrayList();
      for (int i=2006 ;i>=1998 ;i--){
          dates.add(new TreeItem<Part>(new Part(""+i,"","","")));
      }
      root.getChildren().addAll(dates);


        for (Part a:parts){
            for(TreeItem<Part> t:dates){
                if (a.getYear().equals(t.getValue().getYear())){

                    t.getChildren().add(new TreeItem<Part>(new Part(a.getYear(),a.getMake(),a.getModel()
                    ,a.getType())));
                }
            }
        }


        return root;
    }





    public static TreeTableColumn<Part, String> getyearColumn()
    {
        TreeTableColumn<Part, String> yearColumn = new TreeTableColumn<>("Year");
        yearColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("year"));
        return yearColumn;
    }
    public static TreeTableColumn<Part, String> getmakeColumn()
    {
        TreeTableColumn<Part, String> makeColumn = new TreeTableColumn<>("Make");
        makeColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("make"));
        return makeColumn;
    }
    public static TreeTableColumn<Part, String> getmodelColumn()
    {
        TreeTableColumn<Part, String> modelColumn = new TreeTableColumn<>("Model");
        modelColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("model"));
        return modelColumn;
    }
    public static TreeTableColumn<Part, String> gettypeColumn()
    {
        TreeTableColumn<Part, String> typeColumn = new TreeTableColumn<>("Type");
        typeColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("type"));
        return typeColumn;
    }

}
