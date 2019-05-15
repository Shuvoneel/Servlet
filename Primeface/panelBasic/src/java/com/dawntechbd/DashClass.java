package com.dawntechbd;

public class DashClass {

    private String dashTitle;
    private String mobName = "Nokia";
    private String mobModel = "3310";
    private int quantity = 50;
    private double price = 4500.0;
    private String todaysSales = "20 pcs";

    public String getMobName() {
        return mobName;
    }

    public void setMobName(String mobName) {
        this.mobName = mobName;
    }

    public String getMobModel() {
        return mobModel;
    }

    public void setMobModel(String mobModel) {
        this.mobModel = mobModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDashTitle() {
        return dashTitle;
    }

    public void setDashTitle(String dashTitle) {
        this.dashTitle = dashTitle;
    }

    public String getTodaysSales() {
        return todaysSales;
    }

    public void setTodaysSales(String todaysSales) {
        this.todaysSales = todaysSales;
    }

}
