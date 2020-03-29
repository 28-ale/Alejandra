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
    
    private int Codigo;
    private String Nombre_Produc;
    private Float Precio;
    public boolean Modificar;
    public boolean Eliminar;
    
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

    public boolean Guardar(int Codigo, String Nombre_Produc,float Precio,int Existencias){
    boolean respuesta= false;
    
    Connection cn  = null;
    
    cn = ConeccionSQL.getConeccion();
    
    PreparedStatement preSentencia;
    
    try{
        preSentencia = cn.prepareStatement("insert into Productos values (?,?,?,?)");
        
       
        preSentencia.setInt(1, Codigo);
        preSentencia.setString(2, Nombre_Produc);
        preSentencia.setFloat(3, Precio);
        preSentencia.setInt(4, Existencias); 
        
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

    public boolean Modificar(int Codigo, String Nombre_Produc,float Precio,int Existencias){
       
       boolean respuesta = false;
      
      
      Connection cn = null;
      
      
      cn = ConeccionSQL.getConeccion();
      PreparedStatement preSentencia;
      try{
        preSentencia = cn.prepareStatement("UPDATE Productos SET Nombre_Produc=?, Precio=?, Existencias=? where Codigo=?"); 
        preSentencia.setInt(4,Codigo);
        preSentencia.setString(1, Nombre_Produc);
        preSentencia.setFloat(2,Precio);
        preSentencia.setInt(3,Existencias);
        
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
          preSentencia = cn.prepareStatement("DELETE FROM Productos WHERE Codigo=?");
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

    

    
}
