package com.example27.demo27.occupancy;

import com.example27.demo27.Student.StudentController;
import com.example27.demo27.Student.StudentRepo;
import com.example27.demo27.book.Book;
import com.example27.demo27.book.BookController;
import com.example27.demo27.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public class Rent {

    @Autowired
            public StudentRepo studentRepo;

    @Autowired
            public BookRepo bookRepo;

    StudentController studentController=new StudentController();

    BookController bookController=new BookController();


}
