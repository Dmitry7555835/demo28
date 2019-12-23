package com.example27.demo27.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    public StudentRepo studentRepo;

    @GetMapping("/")
    public String student() {
        return "student";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Student> students = studentRepo.findAll();
        return "main";
    }

    @PostMapping("adduser")
    public String studentadd(@RequestParam String name, @RequestParam String password,
                             Map<String, Object> model) {
        Student student = new Student(name, password);
        studentRepo.save(student);
        return "redirect:/mainBook";
    }

    @PostMapping("finduser")
    public String find(@RequestParam int find, Map<String, Object> model) {
        Iterable<Student> student = studentRepo.findById(find);
        model.put("student", student);
        return "mainadmin";
    }

    @PostMapping("deluser")
    public String del(@RequestParam int del, Map<String, Object> model) {
        Iterable<Student> student = studentRepo.deleteById(del);
        return "mainadmin";
    }

    @PostMapping("findAllUser")
    public String findAll(Map<String, Object> model) {
        Iterable<Student> student = studentRepo.findAll();
        model.put("student", student);
        return "mainadmin";
    }

    @GetMapping("/autorizationuser")
    public String autorizationuser(@RequestParam(required = false) String name, @RequestParam(required = false) String password,
                                   Map<String, Object> model) {
        List<Student> student = studentRepo.findByNameAndPassword(name, password);
        for (int i = 0; i < student.size(); i++) {
           // System.out.println(student.get(i).toString());
            if (student.get(i).toString().equals(name + password)) {
                return "MainBook";
            }
        }
        return "/autorizationuser";
    }

    @Transactional
    @PostMapping("take")
    public String updatebook( @RequestParam("nameBook") int id_book, @RequestParam("id_student") int  id_student, Map<String, Object> model){

        studentRepo.updateBook(4,2);


        System.out.println(11111);
        //   studentController.autorizationuser(name,password, modelupdate);
        //   System.out.println(studentController.toString());

        // bookController.findBook(nameBook,modelupdate);findBook(
        return "mainBook";
    }

}


