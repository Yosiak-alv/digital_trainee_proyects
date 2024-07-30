package genericlasses;

public class Animal {
    private String name;
    private String tipo;

    public Animal(String name, String tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public String getTipo() {
        return tipo;
    }
}
