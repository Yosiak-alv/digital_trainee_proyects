package modicaapp.jardin;

import modicaapp.hogar.Persona;

import static modicaapp.hogar.Persona.*;
import static modicaapp.hogar.TipoColor.VERDE;

public class MainJardin {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNombre("andres");
        p.setApellido("modica");
        p.setColorPelo(VERDE);
        System.out.println(p.getNombre());

        Perro perro = new Perro();
        perro.nombre = "Firulais";
        perro.raza = "Pastor Aleman";

        String jugando = perro.jugar(p);
        System.out.println(jugando);
        System.out.println("jugando = " +jugando );
        String saludo = saludar();
        System.out.println("saludo = " +saludo);
        String mujer = GENERO_FEMENINO;
        System.out.println("mujer = " +mujer);
        String hombre = GENERO_MASCULINO;
        System.out.println("hombre = " +hombre);
    }
}