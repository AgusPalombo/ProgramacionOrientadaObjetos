package Ejecucion;
import Negocio.*;

import java.util.Scanner;

public class MenuAdmin {
    private CatalogoProductos catalogoProductos;

    public MenuAdmin(CatalogoProductos catalogoProductos) {
        this.catalogoProductos = catalogoProductos;
    }

    public void opcionesAdmin() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Opciones para administrador:");
            System.out.println("1. Alta de producto");
            System.out.println("2. Baja de producto");
            System.out.println("3. Modificación de producto");
            System.out.println("4. Listar productos");
            System.out.println("0. Volver al menú principal");
            System.out.println("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaProducto();
                    break;
                case 2:
                    bajaProducto();
                    break;
                case 3:
                    modificacionProducto();
                    break;
                case 4:
                    catalogoProductos.mostrarProductos();
                    break;
            }

        } while (opcion != 0);
        
        scanner.close();
    }

    private void altaProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el código del nuevo producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese la descripción del nuevo producto: ");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el precio del nuevo producto: ");
        int precio = scanner.nextInt();

        System.out.println("Ingrese el stock inicial del nuevo producto: ");
        int stock = scanner.nextInt();

        System.out.println("Ingrese el stock mínimo del nuevo producto: ");
        int stockMinimo = scanner.nextInt();

        Producto nuevoProducto = new Producto(codigo, descripcion, precio, stock, stockMinimo);
        catalogoProductos.agregarProducto(nuevoProducto);

        System.out.println("Producto agregado correctamente.");
        
        scanner.close();
    }

    private void bajaProducto() {
        Scanner scanner = new Scanner(System.in);
        catalogoProductos.mostrarProductos();

        System.out.println("Ingrese el código del producto que desea dar de baja: ");
        int codigoProducto = scanner.nextInt();

        Producto productoEliminar = catalogoProductos.buscarProducto(codigoProducto);

        if (productoEliminar != null) {
            catalogoProductos.getProductos().remove(productoEliminar);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
        
        scanner.close();
    }

    private void modificacionProducto() {
        Scanner scanner = new Scanner(System.in);
        catalogoProductos.mostrarProductos();

        System.out.println("Ingrese el código del producto que desea modificar: ");
        int codigoProducto = scanner.nextInt();

        Producto productoModificar = catalogoProductos.buscarProducto(codigoProducto);

        if (productoModificar != null) {
            System.out.println("Ingrese la nueva descripción del producto: ");
            scanner.nextLine(); // Consumir el salto de línea
            String nuevaDescripcion = scanner.nextLine();

            System.out.println("Ingrese el nuevo precio del producto: ");
            int nuevoPrecio = scanner.nextInt();

            System.out.println("Ingrese el nuevo stock del producto: ");
            int nuevoStock = scanner.nextInt();

            System.out.println("Ingrese el nuevo stock mínimo del producto: ");
            int nuevoStockMinimo = scanner.nextInt();

            productoModificar.setDescripcion(nuevaDescripcion);
            productoModificar.setPrecio(nuevoPrecio);
            productoModificar.setStock(nuevoStock);
            productoModificar.setStockMinimo(nuevoStockMinimo);

            System.out.println("Producto modificado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
        
        scanner.close();
    }
}

