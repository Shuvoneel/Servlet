package com.dawntechbd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class StudentBean {

    private List<Student> students = new ArrayList<>();

    private Part file1;
    private Part file2;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public String upload() throws IOException {
        file1.write("F:\\1246913\\Servlet\\Primeface\\filesUpDown\\web\\resources\\images\\" + getFilename(file1));
        file2.write("F:\\1246913\\Servlet\\Primeface\\filesUpDown\\web\\resources\\images\\" + getFilename(file2));
        students.add(new Student("Mr. Mehedi", getFilename(file1)));
        students.add(new Student("Mr. Hasan", getFilename(file2)));
        System.out.println("Student: " + students.size());

        return "success";
    }

    public static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
