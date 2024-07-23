package sales.models;

import sales.enums.PaymentType;
import sales.utils.GenerateNumber;

public class Client {

    private final int id;
    private final String name;
    private final PaymentType paymentType;

    public Client(String name, PaymentType paymentType) {
        this.id = GenerateNumber.generate();
        this.name = name;
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return  "Cliente: " + name + ", Tipo de Pago: " + paymentType ;
    }
}
