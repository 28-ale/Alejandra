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
            datos = sentencia.executeQuery("SELECT * from Cliente");
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
     //Funcion para insertar en la tabla
    
    public boolean Guardar(String Nombre, String Apellido,String Direccion ,int Edad,String Telefono, String Correo){
    boolean respuesta= false;
    
    Connection cn  = null;
    
    cn = ConeccionSQL.getConeccion();
    
    PreparedStatement preSentencia;
    
    try{
        preSentencia = cn.prepareStatement("insert into Cliente values (?,?,?,?,?,?)");
        
       
        preSentencia.setString(1, Nombre);
        preSentencia.setString(2, Apellido);
     
        preSentencia.setString(3, Direccion);
        
        preSentencia.setString(4, Telefono);
        preSentencia.setString(5, Correo);
        
        preSentencia.setInt(6, Edad);
    
       
        
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
    
     public boolean Eliminar(int id){
      boolean respuesta = false;
      
      Connection cn = null;
      
      cn = ConeccionSQL.getConeccion();
      
      PreparedStatement preSentencia;
      
      try{
          preSentencia = cn.prepareStatement("DELETE FROM Cliente WHERE id=?");
          preSentencia.setInt(1,id);
          int res=preSentencia.executeUpdate();
          if (res==1){
              respuesta= true;
              
          }else{
              respuesta= false;
                      
                      
          }
      }catch (Exception e) {
          System.out.println(e);
      }
      return respuesta;
  }  

  public boolean Modificar(String Nombre, String Apellido,int Edad,String Direccion, String Telefono, String Correo){
       
       boolean respuesta = false;
      
      
      Connection cn = null;
      
      
      cn = ConeccionSQL.getConeccion();
      PreparedStatement preSentencia;
      try{
        preSentencia = cn.prepareStatement("Update Cliente Set nombre=?,apellido=?,edad=?, direccion=?,telefono=?,correo=?"); 
           int Id = 0;
        preSentencia.setInt(0, Id); 
        preSentencia.setString(1, Nombre);
        preSentencia.setString(2, Apellido);
        preSentencia.setInt(4, Edad);
        preSentencia.setString(3, Direccion);
        preSentencia.setString(6, Telefono);
        preSentencia.setString(5, Correo);
      
        
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

    public boolean Guardar(String text, String text0, String text1, int parseInt, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Modificar(String text, String text0, String text1, int parseInt, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
      
  }

    

     


   
        
     
          
     

      

    
    
    
    

