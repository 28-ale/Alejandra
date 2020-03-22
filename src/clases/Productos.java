/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import Utils.ConeccionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alumno L2 Maq-14
 */
public class Productos {
    
     private int Edad;
    private String Fecha;
    private String Direccion;
    
     //funcion para consultar
    public ResultSet consultar(){
        Connection cn = null;
        
        cn =  ConeccionSQL.getConeccion();
        
        Statement sentencia = null;
        
        ResultSet datos = null;
        
        
        //intentamos la consulta
        
        try{
           //creamos la sentencia
            
            sentencia = cn.createStatement();
            datos = sentencia.executeQuery("SELECT * from Productos");
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
     //Funcion para insertar en la tabla

    public boolean Guardar(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
