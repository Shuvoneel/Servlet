package com.dawntechbd.controller;

import com.dawntechbd.entity.Sales;
import com.dawntechbd.implementation.SalesImpl;
import com.dawntechbd.service.SalesService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SalesController {

    private Sales sales;
    private List<Sales> saleses;
    private SalesService service;

    public List<Sales> getSalesList() {
        saleses = new ArrayList<>();
        service = new SalesImpl();
        saleses = service.getSales();
        return saleses;
    }

    public void setSalesList(List<Sales> salesList) {
        this.saleses = salesList;
    }

    public void save() {
        service = new SalesImpl();
        service.save(sales);
    }

    public void update() {
        service = new SalesImpl();
        service.update(sales);
    }

    public Sales getSales() {
        if (sales == null) {
            sales = new Sales();
        }
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }
}
