package com.example.rest01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {


    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student")
    public List<Student> getStudent() {
        return studentService.getAllStudent();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student/{name}/{id}")
    public Student getOneStudentById(@PathVariable String name, @PathVariable int id) {
        return studentService.getStudentById(name, id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/student")
    public List<String> addStudentToList(@RequestBody List<Student> students) {
        return studentService.addStudent(students);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student")
    public String updateStudentToList(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/student/{name}/{id}")
    public String deleteStudentFromList(@PathVariable String name, @PathVariable int id) {
        return studentService.deleteStudent(name, id);
    }

}
