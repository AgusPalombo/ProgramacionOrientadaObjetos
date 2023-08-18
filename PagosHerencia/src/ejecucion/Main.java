package ejecucion;

import negocio.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Factura factura = new Factura();
        Calculador calculador = new Calculador();

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Ingresar pago");
            System.out.println("2. Mostrar detalle de pagos");
            System.out.println("3. Mostrar total de montos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese el monto a pagar (0 para salir): ");
                double monto = scanner.nextDouble();
                if (monto != 0) {
                    System.out.println("Seleccione el tipo de pago:");
                    System.out.println("1. Efectivo");
                    System.out.println("2. Crédito");
                    System.out.println("3. Débito");
                    int tipoPago = scanner.nextInt();

                    Pago pago;
                    if (tipoPago == 1) {
                        pago = new Efectivo();
                    } else if (tipoPago == 2) {
                        pago = new Credito();
                        System.out.print("Ingrese la cantidad de cuotas: ");
                        int cuotas = scanner.nextInt();
                        ((Credito) pago).setCantidadCuotas(cuotas);
                    } else if (tipoPago == 3) {
                        pago = new Debito();
                    } else {
                        System.out.println("Opción no válida");
                        continue;
                    }

                    pago.setMonto(monto);
                    factura.agregarPago(pago);
                    calculador.agregarMonto(pago.getMonto());

                    System.out.println("Pago registrado.");
                }
            } else if (opcion == 2) {
                factura.mostrarPagos();
            } else if (opcion == 3) {
                calculador.mostrarTotalMontos();
            } else if (opcion != 0) {
                System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        System.out.println("Hasta luego!");
        
        scanner.close();
        
    }
}
