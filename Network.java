package model;

import javafx.beans.property.*;

import java.util.ArrayList;

public class Network {

    private final StringProperty firstName = new SimpleStringProperty(this,"firstName","");
    private final StringProperty lastName = new SimpleStringProperty(this,"lastName","");
    private final StringProperty address = new SimpleStringProperty(this,"address","");
    private final IntegerProperty speed = new SimpleIntegerProperty(this, "speed", 0);
    private final StringProperty bandwidth = new SimpleStringProperty(this, "bandwidth", "0");
    private final IntegerProperty duration = new SimpleIntegerProperty(this, "duration", 0);


    public Network (){

    }

    public Network (String firstName,String lastName, String address, Integer speed, String bandwidth, Integer duration){

        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
        this.speed.set(speed);
        this.bandwidth.set(bandwidth);
        this.duration.set(duration);

    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public int getSpeed() {
        return speed.get();
    }

    public IntegerProperty speedProperty() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed.set(speed);
    }

    public String getBandwidth() {
        return bandwidth.get();
    }

    public StringProperty bandwidthProperty() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth.set(bandwidth);
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty() {
        return errorList;
    }

    public boolean isValid() {


        boolean isValid = true;

        if (firstName.get() != null && firstName.get().equals("")) {
            errorList.getValue().add("First name can't be empty!");
            isValid = false;
        }
        if (lastName.get() != null && lastName.get().equals("")) {
            errorList.getValue().add("Last name can't be empty!");
            isValid = false;
        }
        if (address.get() != null && address.get().equals("")) {
            errorList.getValue().add("Address can't be empty!");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public String toString() {
        return "Network{" +
                "firstName=" + firstName.get() +
                ", lastName=" + lastName.get() +
                ", address=" + address.get() +
                ", speed=" + speed.get() +
                ", bandwidth=" + bandwidth.get() +
                ", duration=" + duration.get() +
                '}';
    }
}
