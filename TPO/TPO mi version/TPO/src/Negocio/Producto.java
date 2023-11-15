package Negocio;

//Producto.java
public class Producto {
 private int codigo;
 private String descripcion;
 private int precio;
 private int stock;
 private int stockMinimo;

 public Producto(int codigo, String descripcion, int precio, int stock, int stockMinimo) {
     this.codigo = codigo;
     this.descripcion = descripcion;
     this.precio = precio;
     this.stock = stock;
     this.stockMinimo = stockMinimo;
 }

 public int getCodigo() {
     return codigo;
 }

 public String getDescripcion() {
     return descripcion;
 }

 public int getPrecio() {
     return precio;
 }

 public int getStock() {
     return stock;
 }

 public int getStockMinimo() {
     return stockMinimo;
 }

 public void setDescripcion(String descripcion) {
     this.descripcion = descripcion;
 }

 public void setPrecio(int precio) {
     this.precio = precio;
 }

 public void setStock(int stock) {
     this.stock = stock;
 }

 public void setStockMinimo(int stockMinimo) {
     this.stockMinimo = stockMinimo;
 }

 @Override
 public String toString() {
     return "Código: " + codigo +
             ", Descripción: " + descripcion +
             ", Precio: $" + precio +
             ", Stock: " + stock +
             ", Stock Mínimo: " + stockMinimo;
 }
}
