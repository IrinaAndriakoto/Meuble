/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Irina
 */
public class Connexion {
    public static Connection getConnect() throws Exception{
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection( "jdbc:postgres://localhost:5432/meuble", "postgres", "irina");
            System.out.println("connected");
            return connection;  
        }
        catch(Exception e){
            System.out.println("not connected");
            throw e;
        }
    }
}
