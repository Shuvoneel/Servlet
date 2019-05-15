package com.dawntechbd;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DashView {

    private DashClass dashboard;

    public DashClass getDashboard() {
        if (dashboard == null) {
            dashboard = new DashClass();
            dashboard.setDashTitle("Mobile Details");
        }
        return dashboard;
    }

    public void setDashboard(DashClass dashboard) {
        this.dashboard = dashboard;
    }

}
