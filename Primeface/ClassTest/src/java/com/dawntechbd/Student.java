package com.dawntechbd;

public class Student {

    private String name;
    private String email;
    private String gender;
    private String course;
    private String country;

    public Student() {
    }

    public Student(String name, String email, String gender, String course, String country) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.course = course;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
