package com.dawntechbd.service;

import com.dawntechbd.common.CommonService;
import com.dawntechbd.dao.PurchaseDao;
import com.dawntechbd.entity.Purchase;
import java.util.List;

public class PurchaseService extends CommonService<Purchase> implements PurchaseDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Purchase> findAllPurchaseCategory(int id) throws Exception {
        return ((List<Purchase>) getSession().createQuery("SELECT t from Purchase t where Category.id='" + id + "'").getResultList());
    }
}
