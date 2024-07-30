import modelo.*;

import static modelo.Imprimible.*;

public class Main {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo(new Persona("Juan", "Perez")
                , "Ingeniero en Sistemas", "Desarrollador de Software");

        cv.addExperiencia("Desarrollador Java")
            .addExperiencia("Desarrollador Python")
            .addExperiencia("Desarrollador C++")
            .addExperiencia("Desarrollador C#");

        Libro libro = new Libro(new Persona("Josias", "Perez")
                , "Java para Dummies", Genero.PROGRAMACION);

        libro.addPagina(new Pagina("Introduccion a Java"))
            .addPagina(new Pagina("Variables y tipos de datos"))
            .addPagina(new Pagina("Estructuras de control"))
            .addPagina(new Pagina("Clases y Objetos"))
            .addPagina(new Pagina("Herencia y Polimorfismo"));

        Informe informe = new Informe("Estudio sobre Microservicios"
                , new Persona("Jose", "Perez")
                , new Persona("Maria", "Lopez"));

        imprimir(cv);
        imprimir(libro);
        imprimir(informe);

        //lamba with imprimir
        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "imprimiendo un generico de clase anonima";
            }
        });

        System.out.println(TEXTO_DEFECTO);
    }
}