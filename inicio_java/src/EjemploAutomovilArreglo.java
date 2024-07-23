import automovil.enums.TipoAutomovil;
import automovil.enums.TipoColor;
import automovil.enums.TipoMotor;
import automovil.models.Automovil;
import automovil.models.Motor;
import automovil.models.Persona;
import automovil.models.Tanque;

import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "Perez");
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setTanque(new Tanque());
        subaru.setColor(TipoColor.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(persona1);

        Persona pato = new Persona("Pato", "Donald");
        Automovil mazda = new Automovil("Mazda", "3", TipoColor.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setTanque(new Tanque());
        mazda.setConductor(pato);

        Persona bea = new Persona("Bea", "Triz");
        Automovil nissan = new Automovil("Nissan", "Sentra", TipoColor.GRIS, new Motor(4.0, TipoMotor.BENCINA), new Tanque(50));
        nissan.setConductor(bea);
        nissan.setTipo(TipoAutomovil.PICKUP);

        Persona lalo = new Persona("Lalo", "Mora");
        Automovil suzuki = new Automovil("Suzuki", "Swift", TipoColor.GRIS, new Motor(1.6, TipoMotor.BENCINA), new Tanque(50));
        suzuki.setConductor(lalo);
        suzuki.setColor(TipoColor.AMARILLO);
        suzuki.setTipo(TipoAutomovil.SUV);
        Automovil.setColorPatente(TipoColor.AZUL);

        Automovil audi = new Automovil("Audi", "A3");
        audi.setConductor(new Persona("Luis", "Perez"));

        Automovil[] autos = new Automovil[5];
        autos[0] = subaru;
        autos[1] = mazda;
        autos[2] = nissan;
        autos[3] = suzuki;
        autos[4] = audi;

        Arrays.sort(autos);
        for (Automovil auto : autos) {
            System.out.println(auto);
        }
    }

}
