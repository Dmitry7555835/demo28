package com.example27.demo27.occupancy;

import com.example27.demo27.Student.Student;
import com.example27.demo27.Student.StudentController;
import com.example27.demo27.Student.StudentRepo;
import com.example27.demo27.book.Book;
import com.example27.demo27.book.BookController;
import com.example27.demo27.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class Rent {

    @Autowired
            public StudentRepo studentRepo;

    @Autowired
            public BookRepo bookRepo;

    StudentController studentController=new StudentController();

    BookController bookController=new BookController();

    @PostMapping("/take")
   // @Modifying
   // @Query("update Student  set id_book =4 where id =2")
    public String takeBook(){

       System.out.println(11111);
     //   studentController.autorizationuser(name,password, modelupdate);
     //   System.out.println(studentController.toString());

       // bookController.findBook(nameBook,modelupdate);findBook(
        return "mainBook";
    }
}
