package com.example.rest01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudent() {
        List<Student> tempStudentList = new ArrayList<>();
        studentRepository.findAll()
                .forEach(tempStudentList :: add);
        return tempStudentList;
    }

    public Student getStudentById(String name, int id) {
        Optional<Student> student =studentRepository.findById(new StudentIdentity(name, id));
        return student.orElse(null);
    }

    public List<String> addStudent(List<Student> students) {
        students.forEach(student -> student.getStudentIdentity()
                                            .setId(new Random()
                                            .nextInt(9999))
        );
        students.forEach(student -> studentRepository.save(student));
        List<String> response = new ArrayList<>();
        students.forEach(student -> response.add(student.getStudentIdentity().getName()));
        return response;
    }

    public String updateStudent(Student student) {
        studentRepository.save(student);
        return student.getStudentIdentity().getName();
    }

    public String deleteStudent(String name, int id) {
        Student student = studentRepository.findById(new StudentIdentity(name, id))
                .orElse(null);
        studentRepository.deleteById(new StudentIdentity(name, id));
        if(student != null) {
            return student.getStudentIdentity().getName();
        }
        return null;
    }
}
