package controller;

import entity.ProductDashboard;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class DashboardController {

    private ProductDashboard dashboard;

    public ProductDashboard getDashboard() {
        if (dashboard == null) {
            dashboard = new ProductDashboard();
            dashboard.setDashTitle("Mobile Details");
        }
        return dashboard;
    }

    public void setDashboard(ProductDashboard dashboard) {
        this.dashboard = dashboard;
    }

}
