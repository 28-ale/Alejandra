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
public class Ventas {
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
            datos = sentencia.executeQuery("SELECT * from venta");
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
      //Funcion para insertar en la tabla

    public boolean Guardar(int registro_ventas,int codigo_producto, int cantidad,int total){
    boolean respuesta= false;
    
    Connection cn  = null;
    
    cn = ConeccionSQL.getConeccion();
    
    PreparedStatement preSentencia;
    
    try{
        preSentencia = cn.prepareStatement("insert into venta values (?,?,?,?)");
        
       
        preSentencia.setInt(2, codigo_producto);
        preSentencia.setInt(1, registro_ventas);
        preSentencia.setInt(3, cantidad);
        preSentencia.setInt(4, total); 
        
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

    public boolean Guardar(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}