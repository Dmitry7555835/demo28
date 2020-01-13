package com.example27.demo27.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Check extends TimerTask {

    @Autowired
    StudentRepo studentRepo;
    Date date;

    Timer time = new Timer();
    ScheduledTask st = new ScheduledTask();


        for (int i = 0; i <= 5; i++) {
        Thread.sleep(3000);
        System.out.println("Execution in Main Thread. #" + i);
        if (i == 5) {
            System.out.println("Application Terminates");

}



