package pjchatbox;

import java.sql.*;
import javax.swing.*;

public class MyConnection {
    //com.mysql.jdbc.Driver
    //com.mysql.cj.jdbc.Driver
    
    public Connection getConnection() {
        //1. MySQL
//        try {
//            // Driver MySQL (5.x thì dùng com.mysql.jdbc.Driver, 8.x thì dùng com.mysql.cj.jdbc.Driver)
//            Class.forName("com.mysql.jdbc.Driver");
//            //1. MySQL
//            String URL = "jdbc:mysql://localhost/quanlytaikhoan?user=root&password=";
//
//            Connection con = DriverManager.getConnection(URL);
//            return con;
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }

        //1.1 MySQL-mssql-jdbc-13.2.0.jre11.jar
//        try {
//            // Driver MySQL (5.x thì dùng com.mysql.jdbc.Driver, 8.x thì dùng com.mysql.cj.jdbc.Driver)
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //1. MySQL            
//            String URL = "jdbc:mysql://localhost:/quanlytaikhoan?user=root&password=&serverTimezone=UTC";
//
//            Connection con = DriverManager.getConnection(URL);
//            return con;
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }

        
        //2. SQL-Server 
        try {
            // Driver MySQL (5.x thì dùng com.mysql.jdbc.Driver, 8.x thì dùng com.mysql.cj.jdbc.Driver)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //1. MySQL
                        // URL kết nối//==localhost:1433
            String url = "jdbc:sqlserver://localhost;encrypt=false;"
                    + "trustServerCertificate=true;Database=chat_app"
                    + ";user=huy;password=123456";
            
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        
    }
}
