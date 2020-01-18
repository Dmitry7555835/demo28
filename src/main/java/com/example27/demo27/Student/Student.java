package com.example27.demo27.Student;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String password;
    @Column(unique = true)
    String name;

    @Temporal(TemporalType.DATE)
    private Date date_reg;
    String ban;

    public Student() {
    }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                name + password;
    }

}


