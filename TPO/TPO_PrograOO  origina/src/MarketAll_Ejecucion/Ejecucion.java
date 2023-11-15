package MarketAll_Ejecucion;
import java.util.Scanner;
import Empresa_MarketAll.*;

public class Ejecucion {
	public static void main(String[]args) {
		try (Scanner scanner = new Scanner(System.in)) {
			CatalogoProductos catalogo = new CatalogoProductos();
			
			Producto producto1 = new Producto("0001","Auriculares gamer",200.00,100,25);
			Producto producto2 = new Producto("0002","Parlantes de estudio",500.00,200,30);
			Producto producto3 = new Producto("0003","Mouse gamer",50.00,300,50);
			Producto producto4 = new Producto("0004","Teclado gamer",150.00,250,50);
			Producto producto5 = new Producto("0005","Placa de video",1000.00,50,10);
			Producto producto6 = new Producto("0006","Cargador de celular",120.00,20,10);
			
			
			catalogo.agregarProducto(producto1);
			catalogo.agregarProducto(producto2);
			catalogo.agregarProducto(producto3);
			catalogo.agregarProducto(producto4);
			catalogo.agregarProducto(producto5);
			catalogo.agregarProducto(producto6);
			
			catalogo.modificarProducto("0002", "Parlantes", 525.00, 210, 30);
			
			Venta venta1 = new Venta(catalogo);
			
			venta1.comprarProducto("0002",3);
			venta1.comprarProducto("0001",2);
			venta1.comprarProducto("0005",6);
			venta1.comprarProducto("0006", 10);
			venta1.comprarProducto("0001", 3);
			venta1.calcularTotal();
			venta1.imprimirFactura();
			
			System.out.println("En que forma de pago abonara?");
			String metodo_pago = scanner.nextLine();
			
			Cliente cliente1=new Cliente(venta1,metodo_pago);
			cliente1.calcularTotalaPagar();
			cliente1.imprimirTotal();
			
			
			catalogo.listarProductos();
		}
	} 
}
