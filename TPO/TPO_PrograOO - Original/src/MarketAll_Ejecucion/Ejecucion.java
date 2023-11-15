package MarketAll_Ejecucion;
import java.util.Scanner;
import Empresa_MarketAll.*;

public class Ejecucion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatalogoProductos catalogo = new CatalogoProductos();
        Venta venta = new Venta(catalogo);

        // Crear productos de ejemplo
        Producto producto1 = new Producto(1, "Auriculares gamer", 200.00, 100, 25);
        Producto producto2 = new Producto(2, "Parlantes de estudio", 500.00, 200, 30);
        Producto producto3 = new Producto(3, "Mouse gamer", 50.00, 300, 50);
        Producto producto4 = new Producto(4, "Teclado gamer", 150.00, 250, 50);
        Producto producto5 = new Producto(5, "Placa de video", 1000.00, 50, 10);
        Producto producto6 = new Producto(6, "Cargador de celular", 120.00, 20, 10);

        catalogo.agregarProducto(producto1);
        catalogo.agregarProducto(producto2);
        catalogo.agregarProducto(producto3);
        catalogo.agregarProducto(producto4);
        catalogo.agregarProducto(producto5);
        catalogo.agregarProducto(producto6);

        System.out.print("Ingrese el tipo de usuario (Admin/Usuario): ");
        String tipoUsuario = scanner.nextLine().toUpperCase();

        if ("ADMIN".equalsIgnoreCase(tipoUsuario)) {
            menuAdmin(scanner, catalogo);
        } else if ("USUARIO".equalsIgnoreCase(tipoUsuario)) {
            menuUsuario(scanner, venta, catalogo);
        } else {
            System.out.println("Tipo de usuario no válido. Saliendo del programa.");
        }

        scanner.close();
    }

    private static void menuAdmin(Scanner scanner, CatalogoProductos catalogo) {
        int opcion;
        do {
            System.out.println("\n===== Menú de Administrador =====");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Listar Productos del Catálogo");
            System.out.println("4. Eliminar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                	agregarProductoDesdeTeclado(scanner, catalogo);
                    break;
                case 2:
                	 System.out.print("Ingrese el código del producto que desea modificar: ");
                	 String codigoProducto = scanner.nextLine();
                	 int codigoProductoI = Integer.parseInt(codigoProducto);
                    
                	 if (catalogo.getProducto(codigoProductoI) != null) {
                	        Producto productoAModificar = catalogo.getProducto(codigoProductoI);
                	        ingresarNuevosDatosProducto(scanner, productoAModificar);
                	        System.out.println("Producto modificado con éxito.");
                	    } else {
                	        System.out.println("¡Error! El producto con el código ingresado no existe.");
                	    }
                    break;
                case 3:
                    catalogo.listarProductos();
                    break;
                case 4:
                	eliminarProductoDesdeTeclado(scanner, catalogo);
                    break;
                case 0:
                    System.out.println("Saliendo del Menú de Administrador...");
                    
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void menuUsuario(Scanner scanner, Venta venta, CatalogoProductos catalogo) {
    	Venta venta1 = new Venta(catalogo);
        int opcion;
        
        do {
            System.out.println("\n===== Menú de Usuario =====");
            System.out.println("1. Comprar Producto");
            System.out.println("2. Calcular Total de la Compra");
            System.out.println("3. Listar Productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            scanner.nextLine();

            switch (opcion) {
            
                case 1:                 	
                	System.out.println("Ingrese el codigo del producto a comprar: ");
            		String codProducto = scanner.nextLine();
            		int codProductoINT = Integer.parseInt(codProducto);
            		
            		System.out.println("Ingrese la cantidad del producto a comprar: ");
            		String cantProducto = scanner.nextLine();
            		int cantProductoINT = Integer.parseInt(cantProducto);
            		
            		
                    
                    venta1.comprarProducto(codProductoINT, cantProductoINT);
                    
                    break;
                    
                case 2:
                    if (venta1 != null) {
                        venta1.calcularTotal();
                        System.out.println("Total de la compra calculado.");
                    } else {
                        System.out.println("No hay una compra en curso. Realice una compra primero.");
                    }                 
                    
                    if (venta1 != null) {
                        venta1.imprimirFactura();
                    } else {
                        System.out.println("No hay una compra en curso. Realice una compra primero.");
                    }
                                    
                	System.out.println("En que forma de pago abonara?: ");
            		String metodo_pago = scanner.nextLine();
            		
                    if (venta1 != null) {
                        Cliente cliente1 = new Cliente(venta1, metodo_pago);
                        cliente1.calcularTotalaPagar();
                        System.out.println("Total a pagar calculado.");
                        cliente1.imprimirTotal();
                    } else {
                        System.out.println("No hay una compra en curso. Realice una compra primero.");
                    }
                    break;
                    
              case 3:
                    catalogo.listarProductos();
                    break;
                case 0:
                    System.out.println("Saliendo del Menú de Usuario...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }
    
    
/*------------------------------------------------------------------------------------------------------*/
    
    private static void agregarProductoDesdeTeclado(Scanner scanner, CatalogoProductos catalogo) {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        int codigoINT = Integer.parseInt(codigo);

        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el stock mínimo del producto: ");
        int stockMinimo = scanner.nextInt();
        scanner.nextLine(); 

        Producto nuevoProducto = new Producto(codigoINT, descripcion, precio, cantidad, stockMinimo);
        catalogo.agregarProducto(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }

    
    private static void ingresarNuevosDatosProducto(Scanner scanner, Producto producto) {
        System.out.print("Ingrese la nueva descripción del producto (" + producto.getDescripcion() + "): ");
        String nuevaDescripcion = scanner.nextLine();
        if (!nuevaDescripcion.isEmpty()) {
            producto.setDescripcion(nuevaDescripcion);
        }

        System.out.print("Ingrese el nuevo precio del producto (" + producto.getPrecio_unidad() + "): ");
        String nuevoPrecioStr = scanner.nextLine();
        if (!nuevoPrecioStr.isEmpty()) {
            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
            producto.setPrecio_unidad(nuevoPrecio);
        }

        System.out.print("Ingrese la nueva cantidad de stock del producto (" + producto.getCant_stock() + "): ");
        String nuevaCantidadStockStr = scanner.nextLine();
        if (!nuevaCantidadStockStr.isEmpty()) {
            int nuevaCantidadStock = Integer.parseInt(nuevaCantidadStockStr);
            producto.setCant_stock(nuevaCantidadStock);
        }

        System.out.print("Ingrese el nuevo stock mínimo del producto (" + producto.getStock_min() + "): ");
        String nuevoStockMinimoStr = scanner.nextLine();
        if (!nuevoStockMinimoStr.isEmpty()) {
            int nuevoStockMinimo = Integer.parseInt(nuevoStockMinimoStr);
            producto.setStock_min(nuevoStockMinimo);
        }
    }
    
    
    private static void eliminarProductoDesdeTeclado(Scanner scanner, CatalogoProductos catalogo) {
        System.out.print("Ingrese el código del producto que desea eliminar: ");
        String codigoProducto = scanner.nextLine();
        int codigoProductoINT = Integer.parseInt(codigoProducto);

        // Verificar si el producto existe antes de intentar eliminarlo
        if (catalogo.getProducto(codigoProductoINT) != null) {
            catalogo.darBajaProducto(codigoProductoINT);
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("¡Error! El producto con el código ingresado no existe.");
        }
    }
}