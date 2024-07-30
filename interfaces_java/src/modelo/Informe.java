package modelo;

public class Informe extends Hoja implements Imprimible {

    private Persona autor;
    private Persona revisor;

    public Informe(String contenido, Persona autor, Persona revisor) {
        super(contenido);
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimir() {
        return "Informe Escrito Por : " + autor + "\n" +
                "Revisado Por : " + revisor + "\n" +
                "Contenido : " + contenido;
    }
}
