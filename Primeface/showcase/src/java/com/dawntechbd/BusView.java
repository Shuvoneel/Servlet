package com.dawntechbd;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
public class BusView {

    private List<Bus> lists;
    private Bus selectedBus;
    private List<Bus> selectedBusses;

    public List<Bus> getLists() {
        lists = new ArrayList<>();
        lists.add(new Bus(100, 1980, "Hundai", "Black"));
        lists.add(new Bus(110, 1985, "Scania", "Blue"));
        lists.add(new Bus(120, 1990, "Tata", "Gray"));
        lists.add(new Bus(130, 1995, "Marcedes", "Red"));
        lists.add(new Bus(140, 2000, "BMW", "Green"));
        return lists;
    }

    public void setLists(List<Bus> lists) {
        this.lists = lists;
    }

    public Bus getSelectedBus() {
        return selectedBus;
    }

    public void setSelectedBus(Bus selectedBus) {
        this.selectedBus = selectedBus;
    }

    public List<Bus> getSelectedBusses() {
        return selectedBusses;
    }

    public void setSelectedBusses(List<Bus> selectedBusses) {
        this.selectedBusses = selectedBusses;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Bus Selected", ((Bus) event.getObject()).getBrand());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Bus Unselected", ((Bus) event.getObject()).getBrand());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
