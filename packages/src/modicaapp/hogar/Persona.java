package modicaapp.hogar;

public class Persona {
    private String nombre;
    private String apellido;
    private TipoColor colorPelo;

    public static final String GENERO_MASCULINO = "Masculino";
    public static final String GENERO_FEMENINO = "Femenino";

    public TipoColor getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(TipoColor colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String lanzarPelota(){return "Pelota lanzada";}
    public static String saludar(){return "Hola";}
}
