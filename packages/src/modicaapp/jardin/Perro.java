package modicaapp.jardin;

import modicaapp.hogar.Persona;

public class Perro {
    protected String nombre;
    protected String raza;

    //default
    String jugar(Persona persona){return persona.lanzarPelota();}
}
