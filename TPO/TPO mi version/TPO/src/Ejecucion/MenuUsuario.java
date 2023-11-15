package Ejecucion;
import Negocio.*;

import java.util.Scanner;

public class MenuUsuario {
    private CatalogoProductos catalogoProductos;

    public MenuUsuario(CatalogoProductos catalogoProductos) {
        this.catalogoProductos = catalogoProductos;
    }

    public void opcionesUsuario() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Opciones para usuario:");
            System.out.println("1. Comprar productos");
            System.out.println("2. Listar productos");
            System.out.println("0. Volver al menú principal");
            System.out.println("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarCompra();
                    break;
                case 2:
                    catalogoProductos.mostrarProductos();
                    break;
            }

        } while (opcion != 0);
        
        scanner.close();
    }

    private void realizarCompra() {
        Scanner scanner = new Scanner(System.in);
        catalogoProductos.mostrarProductos();

        System.out.println("Ingrese el código del producto que desea comprar: ");
        int codigoProducto = scanner.nextInt();

        Producto productoSeleccionado = catalogoProductos.buscarProducto(codigoProducto);

        if (productoSeleccionado != null) {
            System.out.println("Ingrese la cantidad que desea comprar: ");
            int cantidad = scanner.nextInt();

            // Verificar stock y realizar la compra
            
            boolean compraExitosa = catalogoProductos.realizarCompra(productoSeleccionado, cantidad);

            if (compraExitosa) {
                System.out.println("Ingrese el método de pago (efectivo, debito, credito): ");
                String metodoPago = scanner.next().toLowerCase();

                Pago pago = null;

                switch (metodoPago) {
                    case "efectivo":
                        pago = new Efectivo();
                    break;
                    
                    case "credito":
                        System.out.println("Ingrese la cantidad de cuotas (2, 3 o 6): ");
                        int cuotas = scanner.nextInt();
                        pago = new Credito();
                        ((Credito) pago).setCuotas(cuotas);
                    break;
                    
                    case "debito":
                    	pago = new Debito();
                    break;
                }

                double descuento = pago.calcularDescuento(productoSeleccionado.getPrecio() * cantidad);
                double recargo = pago.calcularRecargo(productoSeleccionado.getPrecio() * cantidad, ((Credito) pago).getCuotas());

                double totalPagar = (productoSeleccionado.getPrecio() * cantidad) + recargo - descuento;

                System.out.println("Resumen de la compra:");
                System.out.println("Producto: " + productoSeleccionado.getDescripcion());
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Precio unitario: $" + productoSeleccionado.getPrecio());
                System.out.println("Descuento: $" + descuento);
                System.out.println("Recargo: $" + recargo);
                System.out.println("Total a pagar: $" + totalPagar);

                // Actualizar stock y verificar stock mínimo
                if (productoSeleccionado.getStock() <= productoSeleccionado.getStockMinimo()) {
                    System.out.println("¡Alerta! El stock del producto está en su mínimo.");
                }

                // Informar al usuario si el stock después de la compra es menor al stock mínimo
                if (productoSeleccionado.getStock() < productoSeleccionado.getStockMinimo()) {
                    System.out.println("¡Alerta! El stock después de la compra es menor al mínimo.");
                }
            } else {
                System.out.println("No hay suficiente stock para realizar la compra.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}

