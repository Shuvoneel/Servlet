package controller;

import dao.StudentDao;
import daoImpl.StudentDaoImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Student;

@ManagedBean
public class StudentController {

    private Student student;
    private List<Student> studentsList;
    private StudentDao studentDao;

    public void save() {
        studentDao = new StudentDaoImpl();
        studentDao.add(student);
        System.out.println("Saved Successfully !");
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentsList() {
        studentDao = new StudentDaoImpl();
        studentsList = studentDao.getStudents();
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

}
