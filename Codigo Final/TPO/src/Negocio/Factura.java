package Negocio;


import java.util.HashMap;
import java.util.Scanner;

public class Factura {
    
    Scanner scanner = new Scanner(System.in);
	

    public Factura() {
        
    }
    
    public static void generarFactura(Compras compras) {
        HashMap<Producto, Integer> productosElegidos = compras.getProductosElegidos();

        // Mostrar detalles de la factura
        System.out.println("--- Detalles de la Factura ---");
        for (HashMap.Entry<Producto, Integer> entry : productosElegidos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();

            double precioFinal = producto.getPrecioUnitario() * cantidad;

            System.out.println("Producto: " + producto.getDescripcion() +
                    " - Precio Unitario: " + producto.getPrecioUnitario() +
                    " - Cantidad: " + cantidad +
                    " - Precio Final: " + precioFinal);
        }

        // Selección del tipo de pago
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSeleccione el tipo de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Débito");
        System.out.println("3. Crédito");

        int opcion = scanner.nextInt();
        double montoFinal = 0;

        switch (opcion) {
            case 1:
                montoFinal = new Efectivo().calcularMonto(calcularMontoTotal(productosElegidos));
                System.out.println("Tipo de Pago: Efectivo");
                break;

            case 2:
                montoFinal = new Debito().calcularMonto(calcularMontoTotal(productosElegidos));
                System.out.println("Tipo de Pago: Débito");
                break;

            case 3:
                System.out.println("Ingrese la cantidad de cuotas para tarjeta de crédito (2/3/6):");
                int cuotas = scanner.nextInt();
                montoFinal = new Credito(cuotas).calcularMonto(calcularMontoTotal(productosElegidos));
                System.out.println("Tipo de Pago: Crédito - Cuotas: " + cuotas);
                break;

            default:
                System.out.println("Opción no válida. Se asumirá pago en Efectivo.");
                montoFinal = new Efectivo().calcularMonto(calcularMontoTotal(productosElegidos));
                break;
        }

        System.out.println("Monto Final: " + montoFinal);
    }
    
    
    
    private static double calcularMontoTotal(HashMap<Producto, Integer> productosElegidos) {
        double montoTotal = 0;

        // Recorrer el HashMap de productos elegidos
        for (Producto producto : productosElegidos.keySet()) {
            int cantidad = productosElegidos.get(producto);

            // Calcular el precio total por producto y sumarlo al monto total
            double precioTotalProducto = producto.getPrecioUnitario() * cantidad;
            montoTotal += precioTotalProducto;
        }

        return montoTotal;
    }


    
}

