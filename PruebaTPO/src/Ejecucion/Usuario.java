package Ejecucion;
import Negocio.*;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private Map<Producto, Integer> productosComprados;
 
    public Usuario() {
        this.productosComprados = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productosComprados.put(producto, cantidad);
    }

    public Map<Producto, Integer> getProductosComprados() {
        return productosComprados;
    }


 
}
