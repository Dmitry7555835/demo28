package com.example27.demo27.Student;

import com.example27.demo27.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    String studentName;
    int idStudent;

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
        studentRepo.studentadd(name,password);
        idStudent = studentRepo.studentId(name, password);

        return "redirect:/mainBook";
    }

    @PostMapping("/autorizationuser")
    public String autorizationuser(@RequestParam(required = false) String name, @RequestParam(required = false) String password,
                                   Map<String, Object> model) {
        List<Student> student = studentRepo.findByNameAndPassword(name, password);
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).toString().equals(name + password)) {
                studentName = name;
                idStudent = student.get(i).getId();
                return "MainBook";
            }
        }
        return "/autorizationuser";
    }


    @PostMapping("finduser")
    public String find(@RequestParam int find, Map<String, Object> model) {
        List<Student> student = studentRepo.findById(find);
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

    @RequestMapping(value = "/take", method = RequestMethod.POST)
    public void takeBook(@RequestParam("nameBook") String nameBook) {
        if (nameBook.toUpperCase().equals(studentRepo.selectStudent(nameBook, idStudent))) {
            System.out.println("Книга у вас на руках");
        } else if (nameBook.toUpperCase().equals(studentRepo.selectBook(nameBook.toUpperCase()))) {
            studentRepo.updateBookAmount(nameBook);
            studentRepo.takeBook(nameBook, idStudent);
            System.out.println("книга взята");
        } else if (nameBook == "") {
            System.out.println("Вы ничего не выбрали");
        } else if (!nameBook.toUpperCase().equals(studentRepo.selectBook(nameBook.toUpperCase()))) {
            System.out.println("нету в наличии книги");
        }
    }

    @PostMapping("/returnbook")
    public String returnBook(@RequestParam("nameBook") String nameBook) {
        if (nameBook.toUpperCase().equals(studentRepo.selectStudent(nameBook.toUpperCase(), idStudent))) {
            studentRepo.returnBook(nameBook);
            studentRepo.returnStudent(nameBook, idStudent);
            System.out.println(nameBook + ' ' + studentRepo.selectStudent(nameBook.toUpperCase(), idStudent));
            System.out.println("Книга возвращена");
        } else if (!nameBook.toUpperCase().equals(studentRepo.selectStudent(nameBook, idStudent))) {
            System.out.println("Вы (не брали)/вернули эту книгу");
        }

        return "mainBook";
    }

    @RequestMapping(value = "mybook", method = RequestMethod.GET)
    public void myBook(Map<String, Object> model) {
        Iterable<StudentBook> studentBooks = studentRepo.myBook(idStudent);
        model.put("studentBooks", studentBooks);
        System.out.println(model.put("studentBooks", studentBooks));
    }

}


