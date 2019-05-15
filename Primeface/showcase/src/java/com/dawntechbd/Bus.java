package com.dawntechbd;

public class Bus {

    private int id;
    private String brand;
    private int year;
    private String color;

    public Bus() {
    }

    public Bus(int id, int year, String brand, String color) {
        this.id = id;
        this.year = year;
        this.brand = brand;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
