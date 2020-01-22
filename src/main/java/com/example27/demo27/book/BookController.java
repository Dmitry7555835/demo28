package com.example27.demo27.book;

import com.example27.demo27.Student.StudentBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    public BookRepo bookRepo;

    @GetMapping("/mainBook")
    public String mainBook(@RequestParam(name = "name", required = false, defaultValue = "book") String name,
                           Map<String, Object> modelBooks) {
        modelBooks.put("name", name);
        return "mainBook";
    }

    @PostMapping("addBook")
    public String addbook(@RequestParam String name, @RequestParam String autor, @RequestParam int amount, Map<String, Object> modelBooks) {
        Book book = new Book(name, autor, amount);
        bookRepo.save(book);
        modelBooks.put("book", book);
        return "MainAdmin";
    }

    @PostMapping("delBook")
    public String delBook(@RequestParam int id, Map<String, Object> modelBooks) {
        Iterable<Book> books = bookRepo.deleteById(id);
        modelBooks.put("book", books);
        return "MainAdmin";
    }

    @PostMapping("findBook")
    public String findByName(@RequestParam("nameBook") String nameBook, Map<String, Object> modelBooks) {//Не отображает книгу
        Iterable<Book> books = bookRepo.findByName(nameBook);
        modelBooks.put("book", books);
        return "mainBook";
    }

    @PostMapping("findAllBook")
    public String findall(Map<String, Object> modelBooks) {
        Iterable<Book> books = bookRepo.findAll();
        modelBooks.put("book", books);
        return "mainBook";
    }
}
