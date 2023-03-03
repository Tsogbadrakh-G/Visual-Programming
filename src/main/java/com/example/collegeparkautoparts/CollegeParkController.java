package com.example.collegeparkautoparts;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollegeParkController {

    @FXML
    private Button Close;
    @FXML
    private TextField txtPartName1;

    @FXML
    private TextField txtPartName2;

    @FXML
    private TextField txtPartName3;

    @FXML
    private TextField txtPartName4;

    @FXML
    private TextField txtPartName5;

    @FXML
    private TextField txtPartName6;
    @FXML
    private TextField txtPartNumber1;

    @FXML
    private TextField txtPartNumber2;

    @FXML
    private TextField txtPartNumber3;

    @FXML
    private TextField txtPartNumber4;

    @FXML
    private TextField txtPartNumber5;

    @FXML
    private TextField txtPartNumber6;

    @FXML
    private TextField txtQuantity1;

    @FXML
    private TextField txtQuantity2;

    @FXML
    private TextField txtQuantity3;

    @FXML
    private TextField txtQuantity4;

    @FXML
    private TextField txtQuantity5;

    @FXML
    private TextField txtQuantity6;

    @FXML
    private TextField txtSubTotal1;

    @FXML
    private TextField txtSubTotal2;

    @FXML
    private TextField txtSubTotal3;

    @FXML
    private TextField txtSubTotal4;

    @FXML
    private TextField txtSubTotal5;

    @FXML
    private TextField txtSubTotal6;

    @FXML
    private TextField txtUnitPrice1;

    @FXML
    private TextField txtUnitPrice2;

    @FXML
    private TextField txtUnitPrice3;

    @FXML
    private TextField txtUnitPrice4;

    @FXML
    private TextField txtUnitPrice5;

    @FXML
    private TextField txtUnitPrice6;
    @FXML
    private Button btnRemove1;

    @FXML
    private Button btnRemove2;

    @FXML
    private Button btnRemove3;

    @FXML
    private Button btnRemove4;

    @FXML
    private Button btnRemove5;

    @FXML
    private Button btnRemove6;
    @FXML
    private TreeView<String> tvwAutoParts;
    @FXML
    private TableView<PartDescription> tbvwAutoParts;

    @FXML
    private TableColumn<PartDescription, String> UnitPrice;

    @FXML
    private TableColumn<PartDescription, String> tablePart;

    @FXML
    private TableColumn<PartDescription, String> tablePartName;
    TreeItem<String> rootItem;
    TreeItem<String> subItem;
    ArrayList<PartDescription> parts;
    ListView<String> treeModel;
    ObservableList<TreeItem<String>> items;

    ObservableList<PartDescription> tableData;
    @FXML
    private TextField TotalOrder;
    double TotalPrice;


    Image rootI;
    Image yearsI;
    Image modelI;
    Image makeI;
    Image typeI;
    @FXML
    void initialize() throws IOException {
        rootI=new Image(getClass().getResource("ROOT.png").openStream());
        makeI=new Image(getClass().getResource("MAKE.png").openStream());
        modelI=new Image(getClass().getResource("MODEL.png").openStream());
        yearsI=new Image(getClass().getResource("YEARS.png").openStream());
        typeI=new Image(getClass().getResource("TYPE.png").openStream());
        treeModel=new ListView<>();
        rootItem=new TreeItem<String>("College Park Auto Park", new ImageView(rootI));
        rootItem.setExpanded(true);
        items= FXCollections.observableArrayList();
        addNodes();
        tvwAutoParts.setRoot(rootItem);
        tableData=FXCollections.observableArrayList();
        buildParts();
       addSubNodes();
       i=0;


      TotalPrice=0;
       txtQuantity1.textProperty().addListener(new ChangeListener<String>() {
           @Override
           public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
               int t=Integer.parseInt(t1);
               double p= Double.parseDouble(txtUnitPrice1.textProperty().getValue());
               TotalPrice+=p*t;
               txtSubTotal1.setText( String.valueOf(p*t));
               TotalOrder.setText(String.valueOf(TotalPrice));
           }
       });
        txtQuantity2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int t=Integer.parseInt(t1);
                double p= Double.parseDouble(txtUnitPrice2.textProperty().getValue());
                TotalPrice+=p*t;
                txtSubTotal2.setText(String.valueOf(p*t));
                TotalOrder.setText(String.valueOf(TotalPrice));
            }
        });
        txtQuantity3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int t=Integer.parseInt(t1);
                double p= Double.parseDouble(txtUnitPrice3.textProperty().getValue());
                TotalPrice+=p*t;
                txtSubTotal3.setText(String.valueOf(p*t));
                TotalOrder.setText(String.valueOf(TotalPrice));
            }
        });
        txtQuantity4.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int t=Integer.parseInt(t1);
                double p= Double.parseDouble(txtUnitPrice4.textProperty().getValue());
                TotalPrice+=p*t;
                txtSubTotal4.setText(String.valueOf(p*t));
                TotalOrder.setText(String.valueOf(TotalPrice));
            }
        });
        txtQuantity5.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int t=Integer.parseInt(t1);
                double p= Double.parseDouble(txtUnitPrice5.textProperty().getValue());
                TotalPrice+=p*t;
                txtSubTotal5.setText( String.valueOf(p*t));
                TotalOrder.setText(String.valueOf(TotalPrice));
            }
        });
        txtQuantity6.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                int t=Integer.parseInt(t1);
                double p= Double.parseDouble(txtUnitPrice6.textProperty().getValue());
                TotalPrice+=p*t;
                txtSubTotal6.setText( String.valueOf(p*t));
                TotalOrder.setText(String.valueOf(TotalPrice));
            }
        });
    }


    int i;
    @FXML
    void tblvwClick(MouseEvent event) {
        if (event.getClickCount()==2) {
            String ID = String.valueOf(tbvwAutoParts.getSelectionModel().getSelectedItem().getID());
            String name = tbvwAutoParts.getSelectionModel().getSelectedItem().getName();
            double uprice = tbvwAutoParts.getSelectionModel().getSelectedItem().getPrice();
            i++;
            switch (i) {
                case 1:
                    txtPartNumber1.setText(ID);
                    txtPartName1.setText(name);
                    txtUnitPrice1.setText(String.valueOf(uprice));
                    break;
                case 2:
                    txtPartNumber2.setText(ID);
                    txtPartName2.setText(name);
                    txtUnitPrice2.setText(String.valueOf(uprice));
                    break;
                case 3:
                    txtPartNumber3.setText(ID);
                    txtPartName3.setText(name);
                    txtUnitPrice3.setText(String.valueOf(uprice));
                    break;
                case 4:
                    txtPartNumber4.setText(ID);
                    txtPartName4.setText(name);
                    txtUnitPrice4.setText(String.valueOf(uprice));
                    break;
                case 5:
                    txtPartNumber5.setText(ID);
                    txtPartName5.setText(name);
                    txtUnitPrice5.setText(String.valueOf(uprice));
                    break;

                default:
                    txtPartNumber6.setText(ID);
                    txtPartName6.setText(name);
                    txtUnitPrice6.setText(String.valueOf(uprice));
                    break;

            }
        }
    }

    @FXML
    void TreeViewClick(MouseEvent event) {
        if (event.getClickCount()==2) {
            TreeItem<String> item = tvwAutoParts.getSelectionModel().getSelectedItem();
            String year = item.getParent().getParent().getParent().getValue();
            String mk = item.getParent().getParent().getValue();
            String mdl = item.getParent().getValue();

            String type= item.getValue();
            for (PartDescription p : parts) {
                if (p.getYr() == Integer.parseInt(year) && p.getMk().equals(mk) &&
                        p.getMdl().equals(mdl) && p.getCat().equals(type) )
                {
                     tableData.add(p);
                     tablePart.setCellValueFactory(new PropertyValueFactory<>("ID"));
                     tablePartName.setCellValueFactory(new PropertyValueFactory<>("name"));
                     UnitPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
                     tbvwAutoParts.setItems(tableData);
                }
            }
        }
    }
    void addSubNodes(){
        items=rootItem.getChildren();
        for (PartDescription a:parts){
           for(TreeItem<String> t:items){
               if (a.getYr()==Integer.parseInt(t.getValue())){
                   TreeItem<String> make=new TreeItem<String>(a.getMk(),new ImageView(makeI));
                   TreeItem<String> model=new TreeItem<String>(a.getMdl(), new ImageView(modelI));
                   TreeItem<String> type=new TreeItem<String>(a.getCat(), new ImageView(typeI));
                   model.getChildren().add(type);
                   make.getChildren().add(model);
                   t.getChildren().add(make);
               }
           }
        }
    }

    void addNodes(){
        for (int i=2022 ;i>=1960 ;i--){
            items.add(new TreeItem<String>(""+i,new ImageView(yearsI)));

        }
        rootItem.getChildren().addAll(items);
    }
    void buildParts(){
        parts=new ArrayList<PartDescription>();
        parts.add(new PartDescription(447093, 2002, "Ford",
                "Escort SE L4 2.0", "Engine Electrical",
                "Alternator 75amp  Remanufactured; w/ 75 Amp",
                205.05));
        parts.add(new PartDescription(203815, 2006, "Dodge",
                "Caravan SE L4 2.4", "Cooling System",
                "Radiator Cap", 6.65));
        parts.add(new PartDescription(293047, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Thermostat Gasket", 4.95));
        parts.add( new PartDescription(990468, 2002, "Honda",
                "Civic 1.7 EX 4DR", "Exhaust",
                "Bolt & Spring Kit (Manifold outlet, Muffler Inlet)",
                85.75));
        parts.add(new PartDescription(304158, 1996, "Buick",
                "Regal Custom V6 3.8", "Fuel Injection",
                "Fuel Injector", 82.75));
        parts.add(  new PartDescription(807245, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "CV Boot Clamp 7 x 750mm; 1 Large + 1 Small Clamp",
                1.60));
        parts.add ( new PartDescription(203485, 2001, "Ford",
                "Taurus LX V6 3.0", "Fuel Injection",
                "Oxygen Sensor OE Style 4Wire; Front; 2 Required",
                52.6));
        parts.add( new PartDescription(248759, 1999, "Jeep",
                "Wrangler Sahara", "Air Intake",
                "Air Filter AirSoft Panel", 7.95));
        parts.add( new PartDescription(202848, 1998, "Honda",
                "Accord 2.3 LX 4DR", "Air Intake",
                "Air Filter", 12.55));
        parts.add( new PartDescription(932759, 2006, "Kia",
                "Rio 1.6DOHC16V 4-DR", "Cooling System",
                "Thermostat", 14.45));
        parts.add( new PartDescription(304975, 2000, "Honda",
                "Civic 1.6 EX 4DR", "Suspension",
                "Ball Joint; Front Lower; 2 per car", 40.55));
        parts.add(new PartDescription(208450, 2003, "Chevrolet",
                "Monte Carlo LS V6 3.4", "Fuel Injection",
                "Oxygen Sensor OE connector; Rear", 65.55));
        parts.add( new PartDescription(209480, 2002, "Ford",
                "Focus SE DOHC L4 2.0", "Steering",
                "Steering Rack Remanufactured", 170.85));
        parts.add( new PartDescription(203495, 2004, "Honda",
                "Civic 1.7 EX 4DR", "Climate Control",
                "A/C Clutch; OE compressor = Sanden", 184.95));
        parts.add(new PartDescription(203480, 2007, "Toyota",
                "Corolla", "Air Intake",
                "Air Filter", 12.65));
        parts.add(  new PartDescription(109379, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Fuel Delivery",
                "Fuel Filter; Early Design; Outer Diameter = 55mm",
                30.95));
        parts.add( new PartDescription(935794, 2002, "Ford",
                "Escape XLS 4WD", "Brake",
                "Brake Caliper Remanufactured; Front Right",
                65.55));
        parts.add( new PartDescription(203485, 2006, "BMW",
                "325i", "Climate Control",
                "AC High Pressure Side Switch",
                49.95));
        parts.add(new PartDescription(204875, 1996, "Chevrolet",
                "Monte Carlo Z34 V6 3.4", "Fuel Delivery",
                "Fuel Filter", 8.05));
        parts.add( new PartDescription(937485, 2007, "Toyota",
                "Camry V6", "Air Intake", "Air Filter", 12.95));
        parts.add( new PartDescription(294759, 2001, "Ford",
                "Escape XLT 4WD", "Air Intake",
                "Air Filter Panel", 7.25 ));
        parts.add( new PartDescription(297495, 2003, "Honda",
                "Civic 1.7 EX 4DR", "Brake",
                "Brake Caliper Reman; w/ ProAct Pads; Front Right",
                82.55 ));
        parts.add(new PartDescription(794735, 2006, "BMW",
                "325i", "Climate Control",
                "Cabin Air/Pollen Filter; With Activated Carbon",
                28.05 ));
        parts.add( new PartDescription(937485, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Halogen  SilverStar; 12V 65W; inner-high beam",
                22.85));
        parts.add( new PartDescription(492745, 2005, "Ford",
                "Focus ZX3 L4 2.0", "Air Intake",
                "Fuel Injection Perf Kit", 342.95 ));
        parts.add( new PartDescription(937005, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "CV Boot Clamp 7 x 750mm; For Large End of Boot; inner boot",
                1.60 ));
        parts.add( new PartDescription(293749, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "Axle Nut 24mm x 1;5; rear ",
                2.35 ));
        parts.add( new PartDescription(920495, 2006, "BMW",
                "325i", "Climate Control",
                "Adjustable Telescoping Mirror", 7.95 ));
        parts.add( new PartDescription(204075, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "Wheel Bearing; Rear; 1 per wheel",
                70.15 ));
        parts.add( new PartDescription(979304, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Thermostat Housing", 20.95 ));
        parts.add( new PartDescription(300456, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "Wheel Bearing; Front; 1 per wheel",
                66.65 ));
        parts.add( new PartDescription(404860, 2001, "Ford",
                "Taurus LX V6 3.0", "Suspension",
                "Shock Absorber GR2; Rear; Wagon only",
                39.40 ));
        parts.add( new PartDescription(585688, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Brake",
                "Climate Control", 10.65));
        parts.add( new PartDescription(739759, 2001, "Ford",
                "Taurus LX V6 3.0", "Suspension",
                "Shock Absorber GasaJust; Rear; Wagon only",
                30.95 ));
        parts.add( new PartDescription(927495, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical",
                "Timing Belt Idler Pulley Original Equipment INA",
                65.55 ));
        parts.add( new PartDescription(979374, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Thermostat Gasket", 4.95 ));
        parts.add( new PartDescription(542347, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Brake",
                "Brake Pad Set ProACT Ceramic w/Shims; Front", 80.05 ));
        parts.add( new PartDescription(683064, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator Hose; Upper", 103.75 ));
        parts.add( new PartDescription(248759, 1999, "Jeep",
                "Wrangler Sahara", "Air Intake",
                "Air Filter", 50.95 ));
        parts.add( new PartDescription(973974, 2007, "Toyota",
                "Corolla", "Air Intake",
                "Air Mass Meter; W/o Housing; Meter/sensor only",
                134.95 ));
        parts.add( new PartDescription(285800, 2001, "Ford",
                "Escape XLT 4WD", "Transmission",
                "AT Filter", 34.95 ));
        parts.add( new PartDescription(207495, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Headlight Bulb; 12V 65W; inner-high beam", 9.35 ));
        parts.add( new PartDescription(566676, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Auxiliary Fan Switch", 42.95 ));
        parts.add( new PartDescription(304950, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Headlight Bulb; 12V 51W; outer", 7.85 ));
        parts.add( new PartDescription(797394, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Water Flange Gasket", 0.85 ));
        parts.add( new PartDescription(910203, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Suspension",
                "Strut Mount Inc; Sleeve; Rear Right", 80.85 ));
        parts.add( new PartDescription(790794, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator Hose; Lower", 9.45 ));
        parts.add( new PartDescription(970394, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Suspension",
                "Coil Spring Insulator; Front Lower",
                14.55 ));
        parts.add( new PartDescription(290840, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical",
                "Rod Bearing Set 1 per Rod; Standard; Reqs. 5-per Engine",
                26.95 ));
        parts.add( new PartDescription(209704, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Wiper Blade Excel+; Front Right", 7.25 ));
        parts.add( new PartDescription(200368, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator Drain Plug incl; gasket", 3.15 ));
        parts.add( new PartDescription(200970, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical",
                "Reference Sensor; Flywheel Engine Speed",
                62.05 ));
        parts.add( new PartDescription(542347, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Air Intake",
                "Air Filter", 50.25 ));
        parts.add( new PartDescription(927045, 2001, "Ford",
                "Escape XLT 4WD", "Air Intake",
                "Air Filter", 62.95 ));
        parts.add( new PartDescription(990659, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator OE Plastic tank", 136.85 ));
        parts.add( new PartDescription(440574, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Suspension",
                "Strut Mount Inc; Sleeve; Rear Left",
                80.80 ));

    }

    @FXML
    void btnRemove1Click(ActionEvent event) {
        TotalPrice-=Double.parseDouble(txtSubTotal1.getText());
            txtPartNumber1.setText("");
            txtPartName1.setText("");
            txtUnitPrice1.setText("0.00");
            txtQuantity1.setText("0");
            txtSubTotal1.setText("00.00");
            i=0;
    }

    @FXML
    void btnRemove2Click(ActionEvent event) {
        TotalPrice-=Double.parseDouble(txtSubTotal2.getText());
        txtPartNumber2.setText("");
        txtPartName2.setText("");
        txtUnitPrice2.setText("0.00");
        txtQuantity2.setText("0");
        txtSubTotal2.setText("00.00");
        i=1;
    }

    @FXML
    void btnRemove3Click(ActionEvent event) {
        TotalPrice-=Double.parseDouble(txtSubTotal3.getText());
        txtPartNumber3.setText("");
        txtPartName3.setText("");
        txtUnitPrice3.setText("0.00");
        txtQuantity3.setText("0");
        txtSubTotal3.setText("00.00");
        i=2;
    }

    @FXML
    void btnRemove4Click(ActionEvent event) {
        TotalPrice-=Double.parseDouble(txtSubTotal4.getText());
        txtPartNumber4.setText("");
        txtPartName4.setText("");
        txtUnitPrice4.setText("0.00");
        txtQuantity4.setText("0");
        txtSubTotal4.setText("00.00");
        i=3;
    }

    @FXML
    void btnRemove5Click(ActionEvent event) {
        TotalPrice-=Double.parseDouble(txtSubTotal5.getText());
        txtPartNumber5.setText("");
        txtPartName5.setText("");
        txtUnitPrice5.setText("0.00");
        txtQuantity5.setText("0");
        txtSubTotal5.setText("00.00");
        i=4;
    }

    @FXML
    void btnRemove6Click(ActionEvent event) {
        TotalPrice-=Double.parseDouble(txtSubTotal6.getText());
        txtPartNumber6.setText("");
        txtPartName6.setText("");
        txtUnitPrice6.setText("0.00");
        txtQuantity6.setText("0");
        txtSubTotal6.setText("00.00");
        i=5;
    }
    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }
}
