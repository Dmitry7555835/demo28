package com.example27.demo27.Student;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;
    String password;
    int id_book;
    int amount;
    @Temporal(TemporalType.DATE)
    private Date date_take;
    @Temporal(TemporalType.DATE)
    private Date date_return;

    public Student() {

    }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    @Override
    public String toString() {
        return
                name + password;
    }

}


