package dao;

import java.util.List;
import model.Student;

public interface StudentDao {

    void add(Student student);

    List<Student> getStudents();
}
