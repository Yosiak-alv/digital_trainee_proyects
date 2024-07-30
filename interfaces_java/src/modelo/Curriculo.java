package modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja implements Imprimible{
    private Persona persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculo(Persona persona, String carrera, String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculo addExperiencia(String experiencia) {
        experiencias.add(experiencia);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Nombre: ");

        sb.append(persona).append("\n")
            .append("Resumen: ").append(this.contenido).append("\n")
                .append("Profesion: ").append(this.carrera).append("\n")
                .append("Experiencias: ").append("\n");
        for (String experiencia : experiencias) {
            sb.append("- ").append(experiencia).append("\n");
        }
        return sb.toString();
    }
}
