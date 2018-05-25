
package Modelo;

public class Alumnos {
    private int clave;
    private String nombre;
    private int nota;

    public Alumnos(int clave, String nombre, int nota) {
        this.clave = clave;
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public void save(){
        Conexion conex=new Conexion();
        
    }

    @Override
    public String toString() {
        return "Alumnos{" + "clave=" + clave + ", nombre=" + nombre + ", nota=" + nota + '}';
    }

    
    
}
