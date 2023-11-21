package Negocio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Compras {
    private HashMap<Producto, Integer> productosElegidos;

    public Compras() {
        this.productosElegidos = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productosElegidos.put(producto, cantidad);
    }

    public HashMap<Producto, Integer> getProductosElegidos() {
        return productosElegidos;
    }

    
    public void setProductosElegidos(HashMap<Producto, Integer> productosElegidos) {
		this.productosElegidos = productosElegidos;
	}

	// COMPRAR PRODUCTO
    public static void comprarProducto(Scanner scanner, Compras compras, ArrayList<Producto> productos) {
        System.out.println("Ingrese el código del producto que desea comprar:");
        int codigo = scanner.nextInt();

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                System.out.println("Ingrese la cantidad que desea comprar:");
                int cantidad = scanner.nextInt();

                if (cantidad <= producto.getStock()) {
                	// Agrego el producto
                	compras.agregarProducto(producto, cantidad);
                    // Actualizar stock
                    producto.setStock(producto.getStock() - cantidad);
                    compras.agregarProducto(producto, cantidad);
                    System.out.println("Compra realizada con éxito.");
                } else {
                    System.out.println("No hay suficiente stock disponible para la compra.");
                }
                return;
            }
        }

        System.out.println("No se encontró un producto con el código ingresado.");
    }
}
