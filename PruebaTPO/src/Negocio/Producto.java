package Negocio;

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

 // Getters y Setters (pueden agregarse según sea necesario)

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
}
