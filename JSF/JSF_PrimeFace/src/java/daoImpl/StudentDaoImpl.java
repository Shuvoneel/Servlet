package daoImpl;

import dao.StudentDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Student;

public class StudentDaoImpl implements StudentDao {

    List<Student> list = new ArrayList<>();

    public StudentDaoImpl() {
        list.add(new Student(1, "Shuvo", "Male", "Round-39", new Date(), true, new String[]{"HTML", "Oracle", "Java"}, " I'm from DU"));
        list.add(new Student(2, "Shirin", "Female", "Round-40", new Date(), true, new String[]{"HTML", "Java"}, " I'm from JU"));
    }

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public List<Student> getStudents() {
        return list;
    }

}
