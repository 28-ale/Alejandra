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
public class Clientes {
    
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
            datos = sentencia.executeQuery("SELECT * from Clientes");
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
     //Funcion para insertar en la tabla
    
    public boolean insertar(String Nombre, String Apellido,String Direccion ,int Edad,String Telefono, String Correo,String echa_Ing){
    boolean respuesta= false;
    
    Connection cn  = null;
    
    cn = ConeccionSQL.getConeccion();
    
    PreparedStatement preSentencia;
    
    try{
        preSentencia = cn.prepareStatement("insert into Clientes values (?,?,?,?,?,?,?)");
        
        preSentencia.setString(1, Nombre);
        preSentencia.setString(2, Apellido);
        preSentencia.setString(3, Telefono);
        preSentencia.setString(4, Correo);
        
        int res = preSentencia.executeUpdate();
        
        if(res==1){
            respuesta  = true;
        }else{
            respuesta = false;
        }
    }catch(Exception e){
        System.out.println(e);
    }
    return respuesta;
 }
}
