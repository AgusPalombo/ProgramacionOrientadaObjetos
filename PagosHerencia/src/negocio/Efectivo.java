package negocio;

public class Efectivo extends Pago {
    @Override
    public double calcularMonto() {
        return getMonto() * 0.9; // Descuento del 10%
    }
}
