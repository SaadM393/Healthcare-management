package com.hospital.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        // 1. Load MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Database details
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "Saad1234@"; // apna MySQL password yahan

        // 3. Return connection
        return DriverManager.getConnection(url, user, password);
        
    }
}
