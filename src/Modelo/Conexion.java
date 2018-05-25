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
            
            conectar=DriverManager.getConnection("jdbc:sqlite:‪C:\\Users\\adm\\Documents\\NetBeansProjects\\3Eval\\EjercicioMVC\\BaseMVN.db");
            
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
    
    public static ResultSet select(){
        /*
        Metodo para visualizar toda nuestra base de datos;
        */
        connect();
        try{
            
            st=conectar.prepareStatement("select * from Alumnos");
            rs=st.executeQuery();
            
        }catch(SQLException ex){
            System.out.println("Error-4001: No se pudo realizar la consulta de la base");
        }
        close();
        return rs;
        
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
        select();
        close();
    }
    
    public static void delete(Alumnos alu){
        /*
        Metodo para eliminar cualquier registro que coincida con la clave de nuestra base
        */
        connect();
        try {
            st=conectar.prepareStatement("delete from Alumnos where clave='"+alu.getClave()+"'");
            st.executeUpdate();
        }catch(SQLException ex){
            System.out.println("ERROR:4012: No se pudo eliminar el registro");
        }
        select();
        close();
    }
    
    public static void update(Alumnos alu1, Alumnos alu2){
        /*
        Metodo para modificar un registro que ya pertenece a la base
        */
        try{
        st=conectar.prepareStatement("update Alumnos set clave='"+alu2.getClave()+"'"
        +", nombre='"+alu2.getNombre()+"'"
        +", nota='"+alu2.getNota()+"'"
        +"where clave='"+alu1.getClave()+"';");
        st.executeUpdate();
    }catch(SQLException ex){
            System.out.println("ERROR-4020:No se pudo modificar el registro actual");
    }
        select();
        close();
}
    
    public static ResultSet selectWhere(String buscar){
        /*
        Metodo de busqueda en la base de datos atraves de su clave primaria
        */
        connect();
        try{
            st=conectar.prepareStatement("select * from Alumnos where clave='"+buscar+"'");
            rs=st.executeQuery();
        }catch(SQLException ex){
            System.out.println("ERROR-4032: No se pudo buscar con precision, fallo del codigo o de la busqueda");
        }
        close();
        return rs;
    }
}
