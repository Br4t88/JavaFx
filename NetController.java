package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Network;

import java.util.ArrayList;


public class NetController {
    @FXML
    private TextField firstName, lastName, address;
    @FXML
    private ToggleGroup speed, band, years;
    @FXML
    private ToggleButton speed2, speed5, speed10, speed20, speed50, speed100,
            band1, band5, band10, band100, bandflat,
            duration1, duration2;
    @FXML
    private Button save, clear, delete;
    @FXML
    private TableView<Network> tv;
    @FXML
    private TableColumn tc1, tc2, tc3, tc4, tc5, tc6;
    ObservableList<Network> netList = FXCollections.<Network>observableArrayList();
    Network net;

    public NetController (){

    }

    @FXML
    private void initialize() {
        netList = FXCollections.<Network>observableArrayList();
        net = new Network();


        firstName.textProperty().bindBidirectional(net.firstNameProperty());
        lastName.textProperty().bindBidirectional(net.lastNameProperty());
        address.textProperty().bindBidirectional(net.addressProperty());

        speed.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {

                if (newValue != null) {

                    ToggleButton selected1 = (ToggleButton) newValue;

                    switch (selected1.getId()) {
                        case "speed2":
                            net.speedProperty().set(2);
                            break;
                        case "speed5":
                            net.speedProperty().set(5);
                            break;
                        case "speed10":
                            net.speedProperty().set(10);
                            break;
                        case "speed20":
                            net.speedProperty().set(20);
                            break;
                        case "speed50":
                            net.speedProperty().set(50);
                            break;
                        case "speed100":
                            net.speedProperty().set(100);
                            break;
                    }
                }
            }
        });

        band.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {

                if (newValue != null) {

                    ToggleButton selected2 = (ToggleButton) newValue;

                    switch (selected2.getId()) {
                        case "band1":
                            net.bandwidthProperty().set("1");
                            break;
                        case "band5":
                            net.bandwidthProperty().set("5");
                            break;
                        case "band10":
                            net.bandwidthProperty().set("10");
                            break;
                        case "band100":
                            net.bandwidthProperty().set("100");
                            break;
                        case "bandflat":
                            net.bandwidthProperty().set("Flat");
                            break;
                    }
                }
            }
        });

        years.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {

                if (newValue != null) {

                    ToggleButton selected3 = (ToggleButton) newValue;

                    switch (selected3.getId()) {
                        case "duration1":
                            net.durationProperty().set(1);
                            break;
                        case "duration2":
                            net.durationProperty().set(2);
                            break;
                    }
                }
            }
        });

    }


        @FXML
        private void savePackage(){
            if (net.isValid()){

                netList = tv.getItems();
                ToggleButton selected1 = (ToggleButton) speed.getSelectedToggle();
                ToggleButton selected2 = (ToggleButton) band.getSelectedToggle();
                ToggleButton selected3 = (ToggleButton) years.getSelectedToggle();


                netList.add(new Network(net.getFirstName(), net.getLastName(), net.getAddress(),
                        net.getSpeed(), net.getBandwidth(), net.getDuration()));

                tv.setItems(netList);

            }
            else {

                StringBuilder errMsg = new StringBuilder();

                ArrayList<String> errList = net.errorsProperty().get();

                for(String errList1 : errList) {
                    errMsg.append(errList1);
                }

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Package can't be saved!");
                alert.setHeaderText(null);
                alert.setContentText(errMsg.toString());
                alert.showAndWait();
                errList.clear();
            }
        }

    @FXML
    private void clearPackage() {

        net.firstNameProperty().set("");
        net.lastNameProperty().set("");
        net.addressProperty().set("");
        speed.selectToggle(null);
        band.selectToggle(null);
        years.selectToggle(null);
        }

    @FXML
    private void deletePackage() {
        netList = tv.getItems();

        int index = tv.selectionModelProperty().getValue().getSelectedIndex();
        netList.remove(index);


        tv.setItems(netList);
    }
    }

