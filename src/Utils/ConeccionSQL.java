/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author LAB2MAQ12
 */
public class ConeccionSQL {

    /**
     * @param args the command line arguments
     */
    //FUNCION PARA CONECTAR A LA BASE DE DATOS
     public static Connection getConeccion(){
        //creamos la variable de connexion
        Connection coneccion = null;
        try{
            //intentamos la conexion,llamamos la clase SQL
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            
            //creamos la cadena de conexion
            String url = "jdbc:sqlserver://DESKTOP-5VKMH4M;databaseName=Tienda;user=ICO;password=12345;";
            
            
            //conectamos
            coneccion = DriverManager.getConnection(url);
            
            
            System.out.println("Conexion satisfactoria :D");
            
        }catch(Exception ex){
            System.out.println("error al conectar"+ex.getMessage());
        }
        return coneccion;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
           getConeccion();
    }
    
}
