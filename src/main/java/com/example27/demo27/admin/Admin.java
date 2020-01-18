package com.example27.demo27.admin;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {


    String query = "insert into admin (id,name,password)  values (2, 'admin', 'admin')";

/*    static final String adminPass = "admin";
    static final String PASSWORD = "admin";
    static void aaa(){
        @Query(value =
    }*/

    @Id
    @GeneratedValue
    int id;
    String name;
    String password;

    public Admin() {
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
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

    @Override
    public String toString() {
        return
                name + password;
    }
}
