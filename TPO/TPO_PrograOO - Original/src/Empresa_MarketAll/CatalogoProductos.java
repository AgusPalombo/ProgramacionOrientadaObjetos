package Empresa_MarketAll;
import java.util.ArrayList;

public class CatalogoProductos {
	private ArrayList <Producto> listaProductos;
	
	public CatalogoProductos() {
		listaProductos=new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto product) {
		listaProductos.add(product);
	}
	
	public Producto getProducto(int codigoProductoI) {
		for(Producto product:listaProductos) {
			if(product.getCodigo()==codigoProductoI) {
				return product;
			}
		}
		return null;
	}
	
	public void modificarProducto(int codigo, String nuevaDescripcion, double nuevoPrecioUnitario, int nuevaCantStock, int nuevoStockMin) {
		for(Producto producto:listaProductos) {
			if (producto.getCodigo()==codigo) {
				producto.setDescripcion(nuevaDescripcion);
				producto.setPrecio_unidad(nuevoPrecioUnitario);
				producto.setStock_min(nuevoStockMin);
				break;
				
			}
		}
	}
	
	public void listarProductos() {
		for(Producto product : listaProductos) {
			System.out.println("Codigo: "+product.getCodigo()+"\t");
			System.out.println("Descripcion: "+product.getDescripcion()+"\t");
			System.out.println("Precio por unidad: $"+product.getPrecio_unidad()+"\t");
			System.out.println("Cantidad de stock: "+product.getCant_stock()+"\t");
			System.out.println("Stock minimo: "+product.getStock_min()+"\t");
			System.out.println(" ");
		}
	}
	
	public void darBajaProducto(int codigo) {
		for (Producto product:listaProductos) {
			if(product.getCodigo()==codigo) {
				listaProductos.remove(product);
				break;
			}
		}
	}
}
