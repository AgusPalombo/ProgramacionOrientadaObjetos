package Ejecucion;
import Negocio.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();
        Compras compras = new Compras();
        Admin admin = new Admin();
        
     // Ejemplo: algunos productos para iniciar el programa
        productos.add(new Producto(1, "Camisa", 25.0, 50, 10));
        productos.add(new Producto(2, "Pantalón", 40.0, 30, 5));
        productos.add(new Producto(3, "Zapatos", 60.0, 20, 8));

        while (true) {
            System.out.println("\n--- Sistema de Compras ---");
            System.out.println("Ingrese el tipo de Usuario:");
            System.out.println("1. Ingresar como Admin");
            System.out.println("2. Ingresar como Usuario");
            System.out.println("3. Salir");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese contraseña de Admin:");
                    String password = scanner.nextLine();

                    if (admin.verificarPassword(password)) {
                        menuAdmin(scanner, admin, productos);
                    } else {
                        System.out.println("Contraseña incorrecta. Intenta de nuevo.");
                    }
                    break;

                case 2:
                    compras = new Compras();
                    menuUsuario(scanner, compras, productos);
                    break;

                case 3:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
    
    //--------------------------------------------------------------METODOS MAIN---------------------------------------------------------
    
    private static void menuAdmin(Scanner scanner, Admin admin, ArrayList<Producto> productos) {
        while (true) {
            System.out.println("\n--- Menú de Admin ---");
            System.out.println("1. Alta de Producto");
            System.out.println("2. Baja de Producto");
            System.out.println("3. Modificación de Producto");
            System.out.println("4. Listar Productos");
            System.out.println("5. Volver al Menú Principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

        
			switch (opcion) {
            case 1:
                Producto.altaProducto(scanner, productos);
                break;

            case 2:
                Producto.bajaProducto(scanner, productos);
                break;

            case 3:
                Producto.modificacionProducto(scanner, productos);
                break;

            case 4:
                // Lógica para listar productos
                Producto.listarProductos(productos);
                break;

            case 5:
                System.out.println("Volviendo al Menú Principal.");
                return;
                
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

   
    private static void menuUsuario(Scanner scanner, Compras compras, ArrayList<Producto> productos) {
        while (true) {
            System.out.println("\n--- Menú de Usuario ---");
            System.out.println("1. Listar Productos Disponibles");
            System.out.println("2. Comprar Producto");
            System.out.println("3. Emitir Factura");
            System.out.println("4. Volver al Menú Principal");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    Producto.listarProductos(productos);
                    break;

                case 2:             
                    Compras.comprarProducto(scanner, compras, productos);
                    break;

               case 3:
                     Factura.generarFactura(compras);
                    break;

                case 4:
                    System.out.println("Volviendo al Menú Principal.");
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
    
    
    
    
}
