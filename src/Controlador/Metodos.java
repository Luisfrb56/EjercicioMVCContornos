package Controlador;

import Modelo.Alumnos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Metodos {
    /*
    La clase metodo es la unica del package del controlador y nos sirve para dirigir los metodos de las clases del Modelo.
    */
    public static ArrayList<Alumnos> alus=new ArrayList();
    
    public static void visualizarAlumnos(){
        /*
        metodo para visualizar el select del la clase modelo
        */
        try{
            ResultSet rs=Modelo.Conexion.select();
            
            alus.clear();
            
            while(rs.next()){
                alus.add(new Alumnos(rs.getInt("clave"),rs.getString("nombre"),rs.getInt("nota")));
            }
                rs.close();
                
        }catch(SQLException ex){
            System.out.println("ERROR:"+ ex.getMessage());
        }
        Modelo.Conexion.close();
    }
    
    public static void nuevoAlumno(Alumnos alu){
        /*
        Metodo insert del package modelo clase conexion
        */
        Modelo.Conexion.insert(alu);
        visualizarAlumnos();
    }
    
    public static void eliminarAlumno(Alumnos alu){
        /*
        Metodo delete del package modelo clase conexion
        */
        Modelo.Conexion.delete(alu);
        visualizarAlumnos();
    }
    
    public static void modificarAlumno(Alumnos alu1,Alumnos alu2){
        /*
        Metodo update del package modelo clase conexion
        */
        Modelo.Conexion.update(alu1, alu2);
        visualizarAlumnos();
    }
    
    public static void buscarAlumno(String buscar){
        /*
        Metodo selectWhere del package Modelo de la clase conexion
        */
        try{
            ResultSet rs=Modelo.Conexion.selectWhere(buscar);
            alus.clear();
            while(rs.next()){
                alus.add(new Alumnos(rs.getInt("clave"),rs.getString("nombre"),rs.getInt("nota")));
            }
        }catch(SQLException ex){
            System.out.println("ERROR"+ex.getMessage());
        }
        Modelo.Conexion.close();
    }
}
