package Negocio;

//Efectivo.java
public class Efectivo extends Pago {
 @Override
 public double calcularDescuento(double total) {
     return total * 0.1;
 }

 @Override
 public double calcularRecargo(double total, int cuotas) {
     return 0;
 }

 @Override
 public String getNombre() {
     return "Efectivo";
 }
}
