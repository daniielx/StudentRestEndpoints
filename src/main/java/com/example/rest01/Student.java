package com.example.rest01;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Student {

    @EmbeddedId
    private StudentIdentity studentIdentity;
    private String year;
    private String Department;

    public Student() {}

    public Student(StudentIdentity studentIdentity, String year, String department) {
        setStudentIdentity(studentIdentity);
        setYear(year);
        setDepartment(department);
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }

    public void setStudentIdentity(StudentIdentity studentIdentity) {
        this.studentIdentity = studentIdentity;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
