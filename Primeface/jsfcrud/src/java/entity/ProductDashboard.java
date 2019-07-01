package entity;

public class ProductDashboard {

    private String dashTitle;
    private String proName = "Nokia";
    private String proModel = "3310";
    private int quantity = 50;
    private double price = 4500.0;
    private String todaysSales = "20 pcs";

    public String getDashTitle() {
        return dashTitle;
    }

    public void setDashTitle(String dashTitle) {
        this.dashTitle = dashTitle;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProModel() {
        return proModel;
    }

    public void setProModel(String proModel) {
        this.proModel = proModel;
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

    public String getTodaysSales() {
        return todaysSales;
    }

    public void setTodaysSales(String todaysSales) {
        this.todaysSales = todaysSales;
    }

}
