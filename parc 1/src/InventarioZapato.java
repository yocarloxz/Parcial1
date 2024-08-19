import java.util.HashMap;
import java.util.Map;

public class InventarioZapato {
    private Map<String, Producto> productos;


    public InventarioZapato() {
        productos = new HashMap<>();
    }

    // Metodo para agregar un producto al inventario
    public void agregarProducto(String nombre, int cantidadInicial) {
        if (productos.containsKey(nombre)) {
            System.out.println("El producto " + nombre + " ya existe en el inventario.");
        } else {
            productos.put(nombre, new Producto(nombre, cantidadInicial));
        }
    }

    // Metodo para vender una cantidad de un producto
    public void venderProducto(String nombre, int cantidad) {
        Producto producto = productos.get(nombre);
        if (producto != null) {
            producto.vender(cantidad);
            if (producto.estaAgotado()) {
                System.out.println("El producto " + nombre + " se ha agotado y su inventario será duplicado.");
                producto.duplicarInventario();
            }
        } else {
            System.out.println("El producto " + nombre + " no existe en el inventario.");
        }
    }

    // Metodo para mostrar toda la información del inventario
    public void mostrarInventario() {
        System.out.println("\nInformación actualizada del inventario:");
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
    }
}
