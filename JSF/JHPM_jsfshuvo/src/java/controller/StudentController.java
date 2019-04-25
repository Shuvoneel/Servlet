package controller;

import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import service.StudentService;
import serviceImpl.StudentServiceImpl;

@ManagedBean
public class StudentController {

    private Student student;
    private List<Student> students;
    private StudentService service;

    public void save() {
        service = new StudentServiceImpl();
        service.save(student);
        FacesContext.getCurrentInstance().addMessage("MessageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Successfull!", null));
        System.out.println("Saved Successfully !");
    }

    public void update() {
        service = new StudentServiceImpl();
        service.update(student);
        FacesContext.getCurrentInstance().addMessage("MessageIdUp", new FacesMessage(FacesMessage.SEVERITY_INFO, "Update Successfull!", null));
        System.out.println("Updated Successfully !");
    }

    public void delete() {
        service = new StudentServiceImpl();
        service.delete(student);
        FacesContext.getCurrentInstance().addMessage("MessageIdUp", new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Successfull!", null));
        System.out.println("Deleted Successfully !");
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
        students = new ArrayList<>();
        service = new StudentServiceImpl();
        students = service.getStudents();
        return students;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.students = studentsList;
    }
}
