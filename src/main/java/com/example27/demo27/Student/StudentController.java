package com.example27.demo27.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String student(Map<String, Object> model) {
        return "student";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Student> students = studentRepo.findAll();
        model.put("students", students);
        return "main";
    }

    @PostMapping("add")
    public String studentadd(@RequestParam String name, @RequestParam String password,
                             Map<String, Object> model) {
        Student student = new Student(name, password);
        studentRepo.save(student);
        return "redirect:/mainBook";
    }

    @PostMapping("find")
    public String find(@RequestParam int find, Map<String, Object> model) {
        Iterable<Student> student = studentRepo.findById(find);
        model.put("student", student);
        return "main";
    }

    @PostMapping("del")
    public String del(@RequestParam int id, Map<String, Object> model) {
        Iterable<Student> student = studentRepo.deleteById(id);
        return "main";
    }

    @PostMapping("findAll")
    public String findAll(Map<String, Object> model) {
        Iterable<Student> student = studentRepo.findAll();
        model.put("student", student);
        return "main";
    }

    @GetMapping("/autorization")
    public String autorization(@RequestParam(required = false) String name, @RequestParam(required = false) String password,
                               Map<String, Object> model) {
        List<Student> student = studentRepo.findByNameAndPassword(name, password);
        System.out.println(student);
        return "/autorization";
    }

}


