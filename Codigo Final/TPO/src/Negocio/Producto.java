package Negocio;

import java.util.ArrayList;
import java.util.Scanner;

//Producto.java

public class Producto {

 private int codigo;
 private String descripcion;
 private double precioUnitario;
 private int stock;
 private int stockMinimo;

 // Constructor
 public Producto(int codigo, String descripcion, double precioUnitario, int stock, int stockMinimo) {
     this.codigo = codigo;
     this.descripcion = descripcion;
     this.precioUnitario = precioUnitario;
     this.stock = stock;
     this.stockMinimo = stockMinimo;
 }

 // Getters y Setters

 public int getCodigo() {
     return codigo;
 }

 public void setCodigo(int codigo) {
     this.codigo = codigo;
 }

 public String getDescripcion() {
     return descripcion;
 }

 public void setDescripcion(String descripcion) {
     this.descripcion = descripcion;
 }

 public double getPrecioUnitario() {
     return precioUnitario;
 }

 public void setPrecioUnitario(double precioUnitario) {
     this.precioUnitario = precioUnitario;
 }

 public int getStock() {
     return stock;
 }

 public void setStock(int stock) {
     this.stock = stock;
 }

 public int getStockMinimo() {
     return stockMinimo;
 }

 public void setStockMinimo(int stockMinimo) {
     this.stockMinimo = stockMinimo;
 }
 
 //-------------------------------METODOS VARIOS---------------------------
 
	 // ALTA PRODUCTOS
	 public static void altaProducto(Scanner scanner, ArrayList<Producto> productos) {
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
	 
	//ELIMINAR PRODUCTO
	 public static void bajaProducto(Scanner scanner, ArrayList<Producto> productos) {
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
	
	 
	//MODIFICAR UN PRODUCTO 
	 
	 public static void modificacionProducto(Scanner scanner, ArrayList<Producto> productos) {
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
	 public static void listarProductos(ArrayList<Producto> productos) {
	     System.out.println("\n--- Listado de Productos ---");
	     for (Producto producto : productos) {
	         System.out.println(producto.getCodigo() + " - " + producto.getDescripcion() +
	                 " - Precio: " + producto.getPrecioUnitario() +
	                 " - Stock: " + producto.getStock() +
	                 " - Stock Mínimo: " + producto.getStockMinimo());
	     }
	 }
	 
	 
	
}