package Empresa_MarketAll;
import java.util.Scanner;

public class Cliente {
	private Venta compra;
	private String metodo_pago;
	private Pago pago;
	
	public Pago metodoPago(String metodo_pago) {
		try (Scanner scanner = new Scanner(System.in)) {
			switch(metodo_pago) {
				case "Efectivo":
					Pago_Efectivo pagoEfectivo = new Pago_Efectivo();
					return pagoEfectivo;
				case "Credito":
					System.out.println("Cuantas cuotas? (2/3/6)");
					int cuotas = scanner.nextInt();
					Pago_Credito pagoCredito = new Pago_Credito(cuotas);
					return pagoCredito;
				case "Debito":
					Pago_Debito pagoDebito = new Pago_Debito();
					return pagoDebito;
				default:
					System.out.println("Método de pago no válido");
			        return null;
			}
		}
	}
	
	public Cliente(Venta compra, String metodo_pago) {
		this.compra=compra;
		this.metodo_pago=metodo_pago;
		this.pago = metodoPago(metodo_pago);
	}
	
	public Double calcularTotalaPagar() {
		pago.setMonto(compra.getTotal());
		Double total = pago.calcularMonto();
		return total;
	}
	
	public void imprimirTotal() {
		switch (metodo_pago) {
			case "Efectivo":
				System.out.println("El total en bruto corresponde a $"+compra.getTotal()+" al abonar con "+ metodo_pago+" se le aplica un descuento del 10% total a abonar es $"+calcularTotalaPagar());
				break;
			case "Credito":
				System.out.println("El total en bruto corresponde a $"+compra.getTotal()+" al abonar con "+ metodo_pago+"se te cobrara un recargo, el total a abonar es $"+calcularTotalaPagar());
				break;
			case "Debito":
				System.out.println("El total en bruto corresponde a $"+compra.getTotal()+" al abonar con "+ metodo_pago+" el precio es el mismo.");
				break;
			default:
				System.out.println("Método de pago no válido");
				break;
				
		}
	}
	
}
