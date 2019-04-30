package implementation;

import entity.Student;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.StudentService;
import util.NewHibernateUtil;

public class StudentImplementation implements StudentService {

    @Override
    public void save(Student student) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.save(student);
        tr.commit();
    }

    @Override
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        list = sn.createCriteria(Student.class).list();
        tr.commit();

        return list;
    }

    @Override
    public void update(Student student) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.saveOrUpdate(student);
        tr.commit();
    }

    @Override
    public void delete(Student student) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sn = sf.getCurrentSession();
        Transaction tr = sn.beginTransaction();
        sn.delete(student);
        tr.commit();
    }

}
