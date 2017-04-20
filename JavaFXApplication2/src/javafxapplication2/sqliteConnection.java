/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Adia
 */
public class sqliteConnection {
    public static Connection Connector(){
        try {
           Class.forName("org.sqlite.JDBC");
           Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Trabajo\\tech\\data.sqlite");
            System.out.println("Conectado");
           return conn;
        } catch (Exception e) {
             System.err.println("Error of connection");
            return null;
        }
    }
}
