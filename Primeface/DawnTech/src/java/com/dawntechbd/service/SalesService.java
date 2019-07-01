package com.dawntechbd.service;

import com.dawntechbd.entity.Sales;
import java.util.List;

public interface SalesService {

    void save(Sales sales);

    void update(Sales sales);

    List<Sales> getSales();
}
