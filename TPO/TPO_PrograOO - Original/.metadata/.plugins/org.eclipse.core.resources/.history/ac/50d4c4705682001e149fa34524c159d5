package Empresa_MarketAll;
import java.util.ArrayList;

public class Venta {
	private CatalogoProductos catalogo;
	private ArrayList<String>Codigos;
	private ArrayList<Integer>Cantidades;
	
	public Venta(CatalogoProductos catalogo) {
		this.catalogo=catalogo;
		Codigos=new ArrayList<String>();
		Cantidades=new ArrayList<Integer>();
	}
	
	Double total =0.0;
	
	public void comprarProducto(String codigo,int cantidad) {
		
		if(cantidad <= catalogo.getProducto(codigo).getCant_stock()) {
			Cantidades.add(cantidad);
			Codigos.add(codigo);
			catalogo.getProducto(codigo).modificarStock(cantidad);
		}else {
			Cantidades.add(0);
		}
	}
	
	public ArrayList<Integer> getListaCantidades() {
		return Cantidades;
	}
	
	public ArrayList<String> getListaCodigos() {
		return Codigos;
	}
	
	public void calcularTotal() {
		for(int i=0;i<Codigos.size();i++) {
			total = total + ((catalogo.getProducto(Codigos.get(i)).getPrecio_unidad())*Cantidades.get(i));
		}
	}
	
	public void imprimirFactura() {
		System.out.println("--------FACTURA--------");
		for(int i=0;i<Codigos.size();i++) {
					
			System.out.println(catalogo.getProducto(Codigos.get(i)).getDescripcion()+" x "+Cantidades.get(i)); 
			System.out.println("Precio C/U: $"+(catalogo.getProducto(Codigos.get(i)).getPrecio_unidad()));
			System.out.println(" ");
		}
		
		System.out.println("Total: $"+ total);
	}
	
	public Double getTotal() {
		return total;
	}
	
}
