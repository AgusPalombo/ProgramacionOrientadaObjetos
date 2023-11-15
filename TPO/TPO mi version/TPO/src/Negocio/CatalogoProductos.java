package Negocio;


import java.util.ArrayList;
import java.util.List;

public class CatalogoProductos {
    private List<Producto> productos;

    public CatalogoProductos() {
        this.productos = new ArrayList<>();
        // Agrega algunos productos iniciales al catálogo
        productos.add(new Producto(1, "Producto A", 10, 50, 10));
        productos.add(new Producto(2, "Producto B", 15, 30, 5));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
    }

    public Producto buscarProducto(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

    public boolean realizarCompra(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            return true;
        }
        return false;
    }
}
