package com.dawntechbd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentBean implements Serializable {

    List<Student> studentList;

    public List<Student> getStudentList() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Shuvo", "shuvo@gmail.com", "Male", "Java", "Rangpur"));
        studentList.add(new Student("Rahmat", "rahmat@gmail.com", "Male", "Java", "Barishal"));
        studentList.add(new Student("Tahmina", "tahmina@gmail.com", "Female", "Java", "Sylhet"));
        studentList.add(new Student("A.Motin", "motin@gmail.com", "Male", "Java", "Rajshahi"));
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

}
