package models;

import java.util.Objects;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId ;

    public Cliente(){this.id = ++ultimoId;}

    public Cliente(String nombre, String apellido){
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return "id=" + id +  '\n' +
                "nombre=" + nombre + '\n' +
                "apellido=" + apellido + '\n';
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || getClass() != obj.getClass()) return false;
        if(obj == this) return true;
        Cliente c = (Cliente)obj;
        return Objects.equals(id, c.id);
    }

    @Override
    public int hashCode(){return Objects.hash(id);}
}
