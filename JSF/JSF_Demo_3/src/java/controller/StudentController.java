package controller;

import javax.faces.bean.ManagedBean;
import model.Student;

@ManagedBean
public class StudentController {

    private Student student;

    public void save() {
        System.out.println(student);
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
}
