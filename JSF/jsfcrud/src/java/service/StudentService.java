package service;

import entity.Student;
import java.util.List;

public interface StudentService {

    void save(Student student);

    void update(Student student);
    
    void delete(Student student);

    List<Student> getStudents();
}
