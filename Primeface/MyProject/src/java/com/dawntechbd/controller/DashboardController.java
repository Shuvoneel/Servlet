package com.dawntechbd.controller;

import com.dawntechbd.entity.Dashboard;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class DashboardController {

    private Dashboard dashboard;

    public Dashboard getDashboard() {
        if (dashboard == null) {
            dashboard = new Dashboard();
            dashboard.setDashTitle("Product Details");
        }
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

}
