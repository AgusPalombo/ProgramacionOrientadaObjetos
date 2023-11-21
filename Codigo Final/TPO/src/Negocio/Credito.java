package Negocio;

//Credito.java

public class Credito extends Pagos{
	private int cuotas;
	
	public Credito(int cuotas) {
		this.cuotas=cuotas;
	}
	


	public double calcularMonto() {
		double recargo=0.0;
		Double total = this.monto;
		
		switch(cuotas) {
		case 2:
			recargo=0.06*monto;
			break;
		case 3:
			recargo=0.12*monto;
			break; 
		case 6:
			recargo=0.20*monto;
			break;
		}
		return total+recargo;
	}
}