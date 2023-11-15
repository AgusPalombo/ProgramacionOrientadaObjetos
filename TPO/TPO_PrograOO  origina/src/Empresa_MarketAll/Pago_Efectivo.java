package Empresa_MarketAll;

public class Pago_Efectivo extends Pago{
	private int descuento=10;
	
	public int getDesceunto() {
		return descuento;
	}
	
	public double calcularMonto() {
		double total;
		
		total = this.monto - (this.monto*descuento/100);
		
		return total;
	}
}
