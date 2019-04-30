package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    private String gender;
    private String round;
    private Date startingDate;
    private boolean status;
    private String[] completedCourse;
    private String notes;

    public Student() {
    }

    public Student(int id, String name, String gender, String round, Date startingDate, boolean status, String[] completedCourse, String notes) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.round = round;
        this.startingDate = startingDate;
        this.status = status;
        this.completedCourse = completedCourse;
        this.notes = notes;
    }

    public Student(String name, String gender, String round, Date startingDate, boolean status, String[] completedCourse, String notes) {
        this.name = name;
        this.gender = gender;
        this.round = round;
        this.startingDate = startingDate;
        this.status = status;
        this.completedCourse = completedCourse;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRound() {
        return round;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public boolean isStatus() {
        return status;
    }

    public String[] getCompletedCourse() {
        return completedCourse;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCompletedCourse(String[] completedCourse) {
        this.completedCourse = completedCourse;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", round=" + round + ", startingDate=" + startingDate + ", status=" + status + ", completedCourse=" + completedCourse + ", notes=" + notes + '}';
    }

}
