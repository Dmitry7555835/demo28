package com.example27.demo27;

import com.example27.demo27.Student.MyActivity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


        try{                                                                    //Для проверки работоспособности кода, в дальнейшем можно будет удалить
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Попытка соединения с базой...");

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1111")){
                System.out.println("Соединение с базой установлено");
                Statement statement = conn.createStatement();
                System.out.println("Попытка внесения первоначальных значений в базу");
                int rowsAdmin = statement.executeUpdate("insert into admin (id,name,password)  values (1, 'admin', 'admin')");
                System.out.printf("Inserted %d rows to table admin", rowsAdmin);
                System.out.println();
                int rowsBook1 = statement.executeUpdate("INSERT INTO book (id,amount,autor,name) VALUES (1, 10, 'Момо','Бонстики')");
                System.out.printf("Inserted %d rows to table book", rowsBook1);
                System.out.println();
                int rowsBook2 = statement.executeUpdate("INSERT INTO book (id,amount,autor,name) VALUES (2, 10, 'Кэрол','Алиса')");
                System.out.printf("Inserted %d rows to table book", rowsBook2);
                System.out.println();
                int rowsBook3 = statement.executeUpdate("INSERT INTO book (id,amount,autor,name) VALUES (3, 10, 'Верн','Луна')");
                System.out.printf("Inserted %d rows to table book", rowsBook3);
            }
        }
        catch(Exception ex){
            System.out.println("Попытка внесения первоначальных данных не удалась");
            System.out.println("Проверьте базу, возможно первоначальные, данные существуют");
        }
    }
}

