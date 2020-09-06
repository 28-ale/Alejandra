/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Utils.ConeccionSQL;
import static Utils.ConeccionSQL.getConeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




/**
 *
 * @author Alumno L2Maq-13
 */
public class I_sesion {
     public String sesion (int Id, String Nombre){
        String respuesta = "";
        String user="";
        Connection cn= null;
       cn= ConeccionSQL.getConeccion();
        
        PreparedStatement preSentencia;
        ResultSet datos= null;
        System.out.println(Id+" "+Nombre);
        try {
            
           preSentencia = cn.prepareStatement("Select * from Empleados where Id =? and Nombre=?");
           preSentencia.setInt(1, Id);
           preSentencia.setString(2, Nombre);
            
           datos=preSentencia.executeQuery();

            /*while (datos.next()){
                user=datos.getString("nivel");//*
               
            }
            
             if (user.equals("")){
                   respuesta = "0";
                                } else {
                 //msm objMatrix = new msm();
                 //objMatrix.Roll=user;
                 respuesta= user;}*/
            
            } catch (Exception e) {System.out.println(e);}
        return respuesta;
    }
    
}
