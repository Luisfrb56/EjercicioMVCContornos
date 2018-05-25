package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    /*
    Creamos el apartado de conexion para la base, con consultas y actualizaciones.
    */
    private static Connection conectar;
    private static PreparedStatement st;
    private static ResultSet rs;
    
    public static void connect(){
        /*
        Metodo para abrir la conexion con la base de datos.
        */
        try{
            
            conectar=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\adm\\Documents\\NetBeansProjects\\3Eval\\EjericioBasesDatos\\MiBase.db");
            
            if(conectar!=null){
                System.out.println("Estas conectado, no olvides desconectar al terminar");
            }
        }catch (SQLException ex) {
            System.out.println("ERROR-4004: No se pudo ejecutar la conexion");

        }
    }
    
    public static void close(){
        /*
        Metodo para cerrar la conexion con la base de datos
        */
        try{
            
            conectar.close();
            
        }catch(SQLException ex){
            System.out.println("ERROR-4005: No se pudo desconectar de la base");
        }
    }
    
    public static void insert(Alumnos alu){
        /*
        Metodo para insertar nuevos registros en la base
        */
        /*
        Primero abrimos la conexion
        */
        connect();
        
        try{
            st=conectar.prepareStatement("insert into alumnos values('"+alu.getClave()+"'"
            +", '"+alu.getNombre()+"'"
            +", '"+alu.getNota()+"' );");
            
            st.execute();
            
        }catch(SQLException ex){
            System.out.println("ERROR-4010: No se pudo insertar el nuevo registro");
        }
    }
}
