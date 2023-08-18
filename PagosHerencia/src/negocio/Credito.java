package negocio;

public class Credito extends Pago {
    private int cantidadCuotas;

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    public double calcularMonto() {
        double nuevoMonto = getMonto() * 1.05; // Aumento del 5%
        System.out.println("Nuevo monto con 5% de interés: " + nuevoMonto);
        System.out.println("Monto a pagar por cada cuota: " + nuevoMonto / cantidadCuotas);
        return nuevoMonto / cantidadCuotas;
    }
}
