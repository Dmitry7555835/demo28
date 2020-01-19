package com.example27.demo27.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StudentBook {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id_book;
    int id_Student;
    public String name_Book;
    @Temporal(TemporalType.DATE)
    public Date date_take;
    @Temporal(TemporalType.DATE)
    public Date date_return;

    public String getName_Book() {
        return name_Book;
    }

    public void setName_Book(String name_Book) {
        this.name_Book = name_Book;
    }

    public StudentBook() {
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public StudentBook(int id_Student) {
        this.id_Student= (id_Student);
    }

    public int getId_Student() {
        return id_Student;
    }

    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }

    public Date getDate_take() {
        return date_take;
    }

    public void setDate_take(Date date_take) {
        this.date_take = date_take;
    }

    public Date getDate_return() {
        return date_return;
    }

    public void setDate_return(Date date_return) {
        this.date_return = date_return;
    }

    @Override
    public String toString() {
        return "StudentBook{" +
                "name_Book='" + name_Book + '\'' +
                ", date_take=" + date_take +
                ", date_return=" + date_return +
                '}';
    }
}
