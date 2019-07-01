package com.dawntechbd.implementation;

import com.dawntechbd.entity.Product;
import com.dawntechbd.service.ProductService;
import com.dawntechbd.util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductImpl implements ProductService {

    @Override
    public void save(Product product) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.save(product);
        tr.commit();
    }

    @Override
    public void update(Product product) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.saveOrUpdate(product);
        tr.commit();
    }

    @Override
    public void delete(Product product) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.delete(product);
        tr.commit();
    }

    @Override
    public List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        list = sn.createCriteria(Product.class).list();
        tr.commit();

        return list;
    }

}
