/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dutan2000
 */
public class ControladorBD {
   
    
    public static Connection conection(){
        Connection coneccion=null;
        try {
            Class.forName("org.postgresql.Driver");
            coneccion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Jhon2000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coneccion;
        
    }
    public static void disconect(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
