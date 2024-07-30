package modicaapp.poo;

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica figura = new Rectangulo();
        figura.dibujar();
        figura = new Circulo();
        figura.dibujar();
    }
}


abstract class FiguraGeometrica {
    public abstract void dibujar();
}

class Rectangulo extends FiguraGeometrica {
    @Override
    public void dibujar() {
        System.out.println("Dibujar Rectangulo");
    }
}

class Circulo extends FiguraGeometrica {
    public void dibujar() {
        System.out.println("Dibujar Circulo");
    }
}
