package com.hibernate.basics;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicsApplication {
	public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String uname = "hbstudent";
        String pword = "hbstudent";

        try{
            System.out.println("Running" + jdbcURL);   
            Connection connection = DriverManager.getConnection(jdbcURL, uname, pword);
            System.out.println("Connection set up:" + connection);
            
        }catch(Exception exc){
            exc.printStackTrace();
        }
	}
}
