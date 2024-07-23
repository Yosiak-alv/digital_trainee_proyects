package automovil.models;

import automovil.enums.TipoAutomovil;
import automovil.enums.TipoColor;

import java.util.Objects;
import java.util.UUID;

public class Automovil implements Comparable<Automovil> {

    private int id;
    private String fabricante;
    private String modelo;
    private Persona conductor;
    private Motor motor;
    private TipoColor color = TipoColor.BLANCO;
    private Tanque tanque;
    private Rueda[] ruedas;
    private int indiceRueda;

    private TipoAutomovil tipo;

    private static TipoColor colorPatente = TipoColor.NARANJA;
    private static int capacidadTanque = 40;
    private static int ultimoId;

    public static final Integer VELOCIDAD_MAXIMA_CARRETERA = 200;
    public static final Integer VELOCIDAD_MAXIMA_CIUDAD = 60;

    public static final String COLOR_ROJO= "Rojo";
    public static final String COLOR_AZUL= "Azul";
    public static final String COLOR_GRIS= "Gris";
    public static final String COLOR_AMARILLO= "Amarillo";
    public static final String COLOR_BLANCO= "Blanco";

    public Automovil() {
        this.id = ++ultimoId;
        this.ruedas = new Rueda[5];
    }

    public Automovil(String fabricante, String modelo) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }
    
    public Automovil(String fabricante, String modelo,TipoColor color) {
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, TipoColor color, Motor motor) {
        this(fabricante, modelo, color);
        this.motor = motor;
    }
    
    public Automovil(String fabricante, String modelo, TipoColor color, Motor motor, Tanque tanque) {
        this(fabricante, modelo, color, motor);
        this.tanque = tanque;
    }
    
    public Automovil(String fabricante, String modelo, TipoColor color, Motor motor, Tanque tanque, Persona conductor, Rueda[] ruedas) {
        this(fabricante, modelo, color, motor, tanque);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public static int getCapacidadTanque() {
        return capacidadTanque;
    }

    public static void setCapacidadTanque(int capacidadTanque) {
        Automovil.capacidadTanque = capacidadTanque;
    }

    public static TipoColor getColorPatente() {
        return colorPatente;
    }

    public static void setColorPatente(TipoColor colorPatente) {
        Automovil.colorPatente = colorPatente;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public int getIndiceRueda() {
        return indiceRueda;
    }

    public void setIndiceRueda(int indiceRueda) {
        this.indiceRueda = indiceRueda;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public Tanque getTanque() {
       if(tanque == null){
           tanque = new Tanque();
       }
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public TipoColor getColor() {
        return color;
    }

    public void setColor(TipoColor color) {
        this.color = color;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Automovil addRueda(Rueda rueda){
        if(indiceRueda < ruedas.length){
            ruedas[indiceRueda++] = rueda;
        }
        return this;
    }

    public String verDetalle(){
        String detalle = "auto.id = " + id + "\n"
                + "auto.fabricante = " +this.getFabricante() + "\n"
                + "auto.modelo = " + this.getModelo() + "\n";

        if(this.getTipo() != null){
            detalle += "auto.tipo = " + this.getTipo().getDescripcion() + "\n";
        }

        detalle += "auto.color = " + this.getColor() + "\n" +
                    "auto.patenteColor = " + colorPatente + "\n";

        if(motor != null){
            detalle += "auto.cilindrada = " +motor.getCilindrada() + "\n";
        }
        if(conductor != null){
            detalle += "auto.conductor " +this.getConductor() + "\n";
        }
        if(getRuedas() != null ){
            detalle += "auto.ruedas = ";
            for(Rueda rueda : this.getRuedas()){
                if(rueda != null){
                    detalle += "\n" + rueda.getFabricante() + " aro: " + rueda.getAro() + " ancho: " + rueda.getAncho();
                }else{
                    detalle += "\n" + "rueda vacia";
                }
            }
        }
        return detalle;
    }

    public String acelerar(int rpm){
        return "el auto " +this.fabricante +" esta acelerando a " +rpm +" rpm";
    }
    public String frenar(){
        return "el auto " +this.fabricante +" "+ this.modelo+ " esta frenando";
    }
    public String acelerarFrenar(int rpm){
        return this.acelerar(rpm) + "\n" + this.frenar();
    }
    public float calcularConsumo(int km, float porcentajeBencina){
        return km / (this.getTanque().getCapacidad() * (porcentajeBencina ));
    }
    public float calcularConsumo(int km, int porcentajeBencina){
        return (float) km / (this.getTanque().getCapacidad() * (porcentajeBencina / 100));
    }
    public static float calcularConsumoEstatico(int km, float porcentajeBencina){
        return km / (Automovil.capacidadTanque * (porcentajeBencina / 100));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Automovil automovil)) return false;
        Automovil a = (Automovil) o;
        return (this.fabricante != null && this.modelo != null
            && this.fabricante.equals(a.getFabricante())
            && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return id + "; " + fabricante + "; " + modelo ;
    }

    @Override
    public int compareTo(Automovil o) {
        return this.fabricante.compareTo(o.fabricante);
    }
}
