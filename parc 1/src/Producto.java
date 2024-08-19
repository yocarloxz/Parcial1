public class Producto {
    private String nombre;
    private int cantidadInicial;
    private int cantidadDisponible;


    public Producto(String nombre, int cantidadInicial) {
        this.nombre = nombre;
        this.cantidadInicial = cantidadInicial;
        this.cantidadDisponible = cantidadInicial;
    }

    // Metodo para vender una cantidad del producto
    public void vender(int cantidad) {
        if (cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
        } else {
            System.out.println("No hay suficiente stock para vender " + cantidad + " unidades de " + nombre);
        }
    }

    // Metodo para duplicar el inventario
    public void duplicarInventario() {
        this.cantidadInicial *= 2;
        this.cantidadDisponible = cantidadInicial;
    }

    // Metodo para verificar si el producto está agotado
    public boolean estaAgotado() {
        return cantidadDisponible <= 0;
    }

    // Metodo para obtener la representación en cadena del producto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Cantidad Inicial: " + cantidadInicial + ", Cantidad Disponible: " + cantidadDisponible;
    }
}
