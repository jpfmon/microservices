package com.montojo.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigData;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {

//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://users_db:3308/users?useSSL=false", "admin", "admin1234");
//            System.out.println("Connection succeeded");
//        } catch (SQLException e) {
//            System.out.println("Exception when trying to stablish connection");
//        }
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
