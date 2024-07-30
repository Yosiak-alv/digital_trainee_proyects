package modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Imprimible{
    private List<Imprimible> paginas;
    private Persona autor;
    private String titulo;
    private Genero  genero;

    public Libro(Persona autor, String titulo, Genero genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = new ArrayList<>();
    }

    public Libro addPagina(Imprimible pagina) {
        paginas.add(pagina);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Titulo: ");

        sb.append(titulo).append("\n")
            .append("Autor: ").append(autor).append("\n")
            .append("Genero: ").append(genero).append("\n")
            .append("Paginas: ").append("\n");
        for (Imprimible pagina : paginas) {
            sb.append(pagina.imprimir()).append("\n");
        }
        return sb.toString();
    }
}
