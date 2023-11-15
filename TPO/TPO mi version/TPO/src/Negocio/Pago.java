package Negocio;


//Pago.java
public abstract class Pago {
 private double descuento;
 private double recargo;

 public double getDescuento() {
     return descuento;
 }

 public void setDescuento(double descuento) {
     this.descuento = descuento;
 }

 public double getRecargo() {
     return recargo;
 }

 public void setRecargo(double recargo) {
     this.recargo = recargo;
 }

 public abstract double calcularDescuento(double total);
 public abstract double calcularRecargo(double total, int cuotas);
 public abstract String getNombre();
}
