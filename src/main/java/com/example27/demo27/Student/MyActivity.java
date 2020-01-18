package com.example27.demo27.Student;


import com.example27.demo27.admin.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

@Configuration
@EnableScheduling
public class MyActivity {

    @Autowired
    protected AdminRepo adminRepo;

    private static final String CRON = "0 0 0 * * *";

    @Scheduled(cron = CRON)
    public void bbb() {
        int x=adminRepo.ban();
        int y=adminRepo.unBan();


            LocalDate date=LocalDate.now();
            System.out.println(date);
        System.out.println(x);
        System.out.println(y);


    }
}
