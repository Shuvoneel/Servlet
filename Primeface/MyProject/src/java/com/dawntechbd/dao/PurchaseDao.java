package com.dawntechbd.dao;

import com.dawntechbd.common.CommonDao;
import com.dawntechbd.entity.Purchase;
import java.util.List;

public interface PurchaseDao extends CommonDao<Purchase> {

    public List<Purchase> findAllPurchaseCategory(int id) throws Exception;
}
