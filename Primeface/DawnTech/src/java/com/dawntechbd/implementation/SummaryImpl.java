package com.dawntechbd.implementation;

import com.dawntechbd.entity.Summary;
import com.dawntechbd.service.SummaryService;
import com.dawntechbd.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SummaryImpl implements SummaryService {

    @Override
    public void save(Summary summary) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.save(summary);
        tr.commit();
    }

    @Override
    public void update(Summary sales) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.saveOrUpdate(sales);
        tr.commit();
    }

    @Override
    public List<Summary> getSummary() {
        List<Summary> list = new ArrayList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        list = sn.createCriteria(Summary.class).list();
        tr.commit();

        return list;
    }

}
