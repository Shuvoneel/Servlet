package com.dawntechbd.service;

import com.dawntechbd.entity.Purchase;
import java.util.List;

public interface PurchaseService {

    void save(Purchase purchase);

    void update(Purchase purchase);

    List<Purchase> getPurchases();
}
