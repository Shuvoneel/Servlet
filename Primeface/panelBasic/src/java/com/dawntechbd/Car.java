package com.dawntechbd;

public class Car {

    private String carName;
    private String carDetails;

    public Car() {
    }

    public Car(String carName, String carDetails) {
        this.carName = carName;
        this.carDetails = carDetails;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarDetails() {
        return carDetails;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }

}
