package Negocio;

//Efectivo.java

public class Efectivo extends Pagos{
	private int descuento=10;
	
	public int getDesceunto() {
		return descuento;
	}
	
	public double calcularMonto(double montoTotal) {
		double total;
		
		total = this.monto - (this.monto*descuento/100);
		
		return total;
	}
}

