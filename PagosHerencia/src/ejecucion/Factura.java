package ejecucion;

import negocio.*;

import java.util.ArrayList;

public class Factura {
    private ArrayList<Pago> pagos;

    public Factura() {
        pagos = new ArrayList<>();
    }

    public void agregarPago(Pago pago) {
        pagos.add(pago);
    }

    public void mostrarPagos() {
        System.out.println("Detalle de pagos:");
        for (Pago pago : pagos) {
            if (pago instanceof Efectivo) {
                System.out.println("Tipo de pago: Efectivo");
            } else if (pago instanceof Credito) {
                System.out.println("Tipo de pago: Crédito");
            } else if (pago instanceof Debito) {
                System.out.println("Tipo de pago: Débito");
            }
            System.out.println("Monto: " + pago.getMonto());
            System.out.println("Monto calculado: " + pago.calcularMonto());
            System.out.println("----------");
        }
    }
}
