package Empresa_MarketAll;

public class Producto {
	private int codigo;
	private String descripcion;
	private Double precio_unidad;
	private int	cant_stock;
	private int stock_min;
	
	public Producto(int codigo,String descripcion,Double precio_unidad,int cant_stock,int stock_min) {
		this.codigo=codigo;
		this.descripcion=descripcion;
		this.precio_unidad=precio_unidad;
		this.cant_stock=cant_stock;
		this.stock_min=stock_min;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getPrecio_unidad() {
		return precio_unidad;
	}

	public int getCant_stock() {
		return cant_stock;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio_unidad(Double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public void setCant_stock(int cant_stock) {
		this.cant_stock = cant_stock;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}
	
	public void modificarStock(int cant_vendidos) {
		cant_stock = cant_stock - cant_vendidos;
	}
}
