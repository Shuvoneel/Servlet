package com.dawntechbd.controller;

import com.dawntechbd.entity.Purchase;
import com.dawntechbd.implementation.PurchaseImpl;
import com.dawntechbd.service.PurchaseService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class PurchaseController {

    private Purchase purchase;
    private List<Purchase> purchases;
    private PurchaseService service;

    public List<Purchase> getPurchaseList() {
        purchases = new ArrayList<>();
        service = new PurchaseImpl();
        purchases = service.getPurchases();
        return purchases;
    }

    public void setPurchasesList(List<Purchase> purchasesList) {
        this.purchases = purchasesList;
    }

    public void save() {
        service = new PurchaseImpl();
        service.save(purchase);
    }

    public void update() {
        service = new PurchaseImpl();
        service.update(purchase);
    }

    public Purchase getPurchase() {
        if (purchase == null) {
            purchase = new Purchase();
        }
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
