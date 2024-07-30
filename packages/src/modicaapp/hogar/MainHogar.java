package modicaapp.hogar;

import modicaapp.jardin.Perro;



public class MainHogar {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro perro = new Perro();

        //String saludo = saludar();
        String saludo2  = Persona.saludar();
        System.out.println(saludo2);
    }
}
