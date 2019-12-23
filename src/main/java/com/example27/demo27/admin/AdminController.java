package com.example27.demo27.admin;

import com.example27.demo27.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    Student student = new Student();

    @Autowired
    public AdminRepo adminRepo;

    @GetMapping("/MainAdmin")
    public String admin(Map<String, Object> modelAdmin) {
        Iterable<Admin> admins = adminRepo.findAll();
        return "MainAdmin";
    }

    @PostMapping("addadmin")
    public String addAdmin(@RequestParam String name, String password, Map<String, Object> modelAdmin) {
        Admin admin = new Admin(name, password);
        adminRepo.save(admin);
        return "MainAdmin";
    }

    @PostMapping("findAllAdmin")
    public String findAllAdmin(Map<String, Object> modelAdmin) {
        Iterable<Admin> admin = adminRepo.findAll();
        modelAdmin.put("admin", admin);
        return "MainAdmin";
    }

    @GetMapping("/autorizationadmin")
    public String autorizatioadmin(@RequestParam(required = false) String name, @RequestParam(required = false) String password,
                                   Map<String, Object> modelAdmin) {
        List<Admin> admins = adminRepo.findByNameAndPassword(name, password);
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).toString().equals(name + password)) {
                return "MainAdmin";
            }
        }
        return "/autorizationadmin";
    }

}



