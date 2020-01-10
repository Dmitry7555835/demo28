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
            if (student.get(i).toString().equals(name + password)) {

                return "MainBook";
            }
        }
        return "/autorizationuser";
    }

    @PostMapping("/blok")
    public void blok (){
        System.out.println(2222);
    }

    @Transactional
    @PostMapping("/take")
    public String takeBook( @RequestParam("nameBook") String nameBook, @RequestParam("studentName") String  studentName,
                              Map<String, Object> model){

       //создать метод на проверку того, что книга уже есть у пользователя и, если есть , то сказать, что книга уже на руках (желательно всплывающим окном)
        blok();

        studentRepo.takeBook(nameBook,  studentName);
        studentRepo.updateBookAmount(nameBook);
        return "mainBook";
    }

}


