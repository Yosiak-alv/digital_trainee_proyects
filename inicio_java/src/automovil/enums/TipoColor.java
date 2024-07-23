package automovil.enums;

public enum TipoColor {
    BLANCO("Blanco"),
    NEGRO("Negro"),
    GRIS("Gris"),
    ROJO("Rojo"),
    AZUL("Azul"),
    NARANJA("Naranja"),
    AMARILLO("Amarillo");

    private final String color;

    TipoColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
