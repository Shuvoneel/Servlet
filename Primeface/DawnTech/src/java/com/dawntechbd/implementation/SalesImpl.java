package com.dawntechbd.implementation;

import com.dawntechbd.entity.Sales;
import com.dawntechbd.service.SalesService;
import com.dawntechbd.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SalesImpl implements SalesService {

    @Override
    public void save(Sales sales) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.save(sales);
        tr.commit();
    }

    @Override
    public void update(Sales sales) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.saveOrUpdate(sales);
        tr.commit();
    }

    @Override
    public List<Sales> getSales() {
        List<Sales> list = new ArrayList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        list = sn.createCriteria(Sales.class).list();
        tr.commit();

        return list;
    }

}
