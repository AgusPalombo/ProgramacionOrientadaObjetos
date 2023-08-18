public class Automovil {
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private boolean encendido;
    private boolean acelerando;

    public Automovil(String marca, String modelo, int año, String color, boolean encendido) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.encendido = encendido;
        this.acelerando = false; // Inicialmente no se está acelerando si el auto está encendido
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public String getColor() {
        return color;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
        acelerando = false;
    }

    public void acelerar() {
        if (encendido) {
            acelerando = true;
            System.out.println("Acelerando el automóvil...");
        } else {
            System.out.println("No se puede acelerar. El automóvil está apagado.");
        }
    }

    public void frenar() {
        acelerando = false;
        System.out.println("Frenando el automóvil.");
    }
}
