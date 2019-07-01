package com.dawntechbd.implementation;

import com.dawntechbd.entity.Purchase;
import com.dawntechbd.service.PurchaseService;
import com.dawntechbd.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PurchaseImpl implements PurchaseService {

    @Override
    public void save(Purchase purchase) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.save(purchase);
        tr.commit();
    }

    @Override
    public void update(Purchase purchase) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.saveOrUpdate(purchase);
        tr.commit();
    }

    @Override
    public List<Purchase> getPurchases() {
        List<Purchase> list = new ArrayList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        list = sn.createCriteria(Purchase.class).list();
        tr.commit();

        return list;
    }

}
