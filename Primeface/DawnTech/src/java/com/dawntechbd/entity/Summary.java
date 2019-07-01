package com.dawntechbd.entity;

public class Summary {

    private String category;
    private String brand;
    private String code;
    private int totalQty = 10;
    private int saleQty = 2;
    private int availableQty = 8;

    public Summary() {
    }

    public Summary(String category, String brand, String code, int totalQty, int saleQty, int availableQty) {
        this.category = category;
        this.brand = brand;
        this.code = code;
        this.totalQty = totalQty;
        this.saleQty = saleQty;
        this.availableQty = availableQty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getSaleQty() {
        return saleQty;
    }

    public void setSaleQty(int saleQty) {
        this.saleQty = saleQty;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

}
