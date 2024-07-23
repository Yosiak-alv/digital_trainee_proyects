import automovil.enums.TipoColor;
import automovil.enums.TipoMotor;
import automovil.models.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Automovil nissan = new Automovil(
                "Nissan",
                "Sentra",
                TipoColor.AZUL,
                new Motor(1.8, TipoMotor.BENCINA),
                new Tanque()
        );

        nissan.addRueda(new Rueda("Michelin", 16, 215));
        nissan.addRueda(new Rueda("Michelin", 16, 215));
        nissan.addRueda(new Rueda("Michelin", 16, 215));
        nissan.addRueda(new Rueda("Michelin", 16, 215));
        nissan.addRueda(new Rueda("Michelin", 16, 215));


        Automovil corolla = new Automovil(
                "Toyota",
                "Corolla",
                TipoColor.ROJO,
                new Motor(1.6, TipoMotor.BENCINA),
                new Tanque(),
                new Persona("Juan", "Perez"),
                new Rueda[]{
                        new Rueda("Michelin", 16, 215),
                        new Rueda("Michelin", 16, 215),
                        new Rueda("Michelin", 16, 215),
                        new Rueda("Michelin", 16, 215)
                }
        );

        System.out.println("Son iguales: " + (nissan == corolla));
        System.out.println("Son iguales (con equals): " + nissan.equals(corolla));

        System.out.println(nissan.verDetalle());
        System.out.println(corolla.verDetalle());

        System.out.println(nissan.equals(new Date()));
        System.out.println(nissan.toString());

        System.out.println(corolla.acelerar(3000));
        System.out.println(corolla.frenar());
        System.out.println(nissan.acelerarFrenar(4300));

        System.out.println("Kilometros por litro: " + nissan.calcularConsumo(300,0.6f));
        System.out.println("Kilometros por litro: " + corolla.calcularConsumo(300,60));
        System.out.println("Kilometros por litro: " + corolla.calcularConsumo(300,60));
    }
}