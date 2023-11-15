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
        Usuario usuario = null;
        Admin admin = new Admin();

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
                    usuario = new Usuario();
                    menuUsuario(scanner, usuario, productos);
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
                    altaProducto(scanner, productos);
                    break;

                case 2:
                	bajaProducto(scanner, productos);
                    break;

                case 3:
                    modificacionProducto(scanner, productos);
                    break;

                case 4:
                    listarProductos(productos);
                    break;

                case 5:
                    System.out.println("Volviendo al Menú Principal.");
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

   
    private static void menuUsuario(Scanner scanner, Usuario usuario, ArrayList<Producto> productos) {
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
                    listarProductos(productos);
                    break;

                case 2:             
                    comprarProducto(scanner, usuario, productos);
                    break;

                case 3:
                    emitirFactura(usuario);
                    break;

                case 4:
                    System.out.println("Volviendo al Menú Principal.");
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
    
    
    // ALTA PRODUCTOS
    private static void altaProducto(Scanner scanner, ArrayList<Producto> productos) {
        System.out.println("Ingrese el código del producto:");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer un entero

        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el precio unitario del producto:");
        double precioUnitario = scanner.nextDouble();

        System.out.println("Ingrese el stock inicial del producto:");
        int stock = scanner.nextInt();

        System.out.println("Ingrese el stock mínimo del producto:");
        int stockMinimo = scanner.nextInt();

        Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, stock, stockMinimo);
        productos.add(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }
// ELIMINAR PRODUCTO
    private static void bajaProducto(Scanner scanner, ArrayList<Producto> productos) {
        System.out.println("Ingrese el código del producto a dar de baja:");
        int codigo = scanner.nextInt();

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                productos.remove(producto);
                System.out.println("Producto dado de baja con éxito.");
                return;
            }
        }

        System.out.println("No se encontró un producto con el código ingresado.");
    }

    
// MODIFICAR UN PRODUCTO 
    
    private static void modificacionProducto(Scanner scanner, ArrayList<Producto> productos) {
        System.out.println("Ingrese el código del producto a modificar:");
        int codigo = scanner.nextInt();

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
            	scanner.nextLine();
            	
                System.out.println("Ingrese la nueva descripción del producto:");
                String nuevaDescripcion = scanner.nextLine();
                producto.setDescripcion(nuevaDescripcion);
                
                
                System.out.println("Ingrese el nuevo precio unitario del producto:");
                double nuevoPrecioUnitario = scanner.nextDouble();
                scanner.nextLine();
                producto.setPrecioUnitario(nuevoPrecioUnitario);

                System.out.println("Ingrese el nuevo stock inicial del producto:");
                int nuevoStock = scanner.nextInt();
                scanner.nextLine(); 
                producto.setStock(nuevoStock);

                System.out.println("Ingrese el nuevo stock mínimo del producto:");
                int nuevoStockMinimo = scanner.nextInt();
                scanner.nextLine(); 
                producto.setStockMinimo(nuevoStockMinimo);

                System.out.println("Producto modificado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró un producto con el código ingresado.");
    }

    // LISTAR PRODUCTOS
    private static void listarProductos(ArrayList<Producto> productos) {
        System.out.println("\n--- Listado de Productos ---");
        for (Producto producto : productos) {
            System.out.println(producto.getCodigo() + " - " + producto.getDescripcion() +
                    " - Precio: " + producto.getPrecioUnitario() +
                    " - Stock: " + producto.getStock() +
                    " - Stock Mínimo: " + producto.getStockMinimo());
        }
    }

    // COMPRAR PRODUCTO
    private static void comprarProducto(Scanner scanner, Usuario usuario, ArrayList<Producto> productos) {
        System.out.println("Ingrese el código del producto que desea comprar:");
        int codigo = scanner.nextInt();

        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                System.out.println("Ingrese la cantidad que desea comprar:");
                int cantidad = scanner.nextInt();

                if (cantidad <= producto.getStock()) {
                	// Agrego el producto
                	usuario.agregarProducto(producto, cantidad);
                    // Actualizar stock
                    producto.setStock(producto.getStock() - cantidad);
                    usuario.agregarProducto(producto, cantidad);
                    System.out.println("Compra realizada con éxito.");
                } else {
                    System.out.println("No hay suficiente stock disponible para la compra.");
                }
                return;
            }
        }

        System.out.println("No se encontró un producto con el código ingresado.");
    }

  //--------------------------------FACTURA---------------------------------------------------------    
    
    private static void emitirFactura(Usuario usuario) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("\n--- Factura ---");
			
			double montoTotal = calcularMontoTotal(usuario);
			
			// Obtener los productos comprados del usuario
			HashMap<Producto, Integer> productosComprados = (HashMap<Producto, Integer>) usuario.getProductosComprados();

			// Calcular el monto total de la factura utilizando los productos comprados
		
			for (Map.Entry<Producto, Integer> entry : productosComprados.entrySet()) {
			    Producto producto = entry.getKey();
			    int cantidad = entry.getValue();
			    double precioTotal = cantidad * producto.getPrecioUnitario();
			    montoTotal += precioTotal;
			    System.out.println(producto.getDescripcion() + " - Cantidad: " +
			            cantidad + " - Precio Total: " + precioTotal);
			}

			// Preguntar al usuario el tipo de pago
			System.out.println("\nSeleccione el tipo de pago:");
			System.out.println("1. Efectivo");
			System.out.println("2. Débito");
			System.out.println("3. Crédito");

			int opcion = scanner.nextInt();
			double montoFinal = 0;

			switch (opcion) {
			    case 1:
			        montoFinal = new Efectivo().calcularMonto(montoTotal);
			        break;

			    case 2:
			        montoFinal = new Debito().calcularMonto(montoTotal);
			        break;

			    case 3:
			        System.out.println("Ingrese la cantidad de cuotas para tarjeta de crédito:");
			        int cuotas = scanner.nextInt();
			        montoFinal = new Credito(cuotas).calcularMonto(montoTotal);
			        break;

			    default:
			        System.out.println("Opción no válida. Se asumirá pago en Efectivo.");
			        montoFinal = new Efectivo().calcularMonto(montoTotal);
			        break;
			}

			// Mostrar el tipo de pago y el monto final
			System.out.println("Tipo de Pago:");
			switch (opcion) {
			    case 1:
			        System.out.println("Efectivo");
			        break;

			    case 2:
			        System.out.println("Débito");
			        break;

			    case 3:
			        System.out.println("Crédito");
			        break;

			    default:
			        System.out.println("Opción no válida");
			        break;
			}

			System.out.println("Monto Final: " + montoFinal);
		}
    }

    
//--------------------------------CALCULAR MONTO FINAL---------------------------------------------------------
    
    private static double calcularMontoTotal(Usuario usuario) {
        Map<Producto, Integer> productosComprados = usuario.getProductosComprados();

        double montoTotal = 0;
        for (Map.Entry<Producto, Integer> entry : productosComprados.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            double precioTotal = cantidad * producto.getPrecioUnitario();
            montoTotal += precioTotal;
        }

        return montoTotal;
    }
   

}

