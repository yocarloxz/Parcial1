import java.util.Scanner;

public class GestionInventarioZapatos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventarioZapato inventario = new InventarioZapato();
        int opcion;

        while (true) {
            // Mostrar el menú
            System.out.println("\nMenú de Gestión de Inventario:");
            System.out.println("1. Agregar un nuevo producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción (1-4): ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Ingreso de información de productos
                    while (true) {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la cantidad inicial del producto: ");
                        int cantidadInicial = scanner.nextInt();
                        scanner.nextLine();

                        inventario.agregarProducto(nombre, cantidadInicial);
                        System.out.println("Producto agregado exitosamente.");

                        String respuesta;
                        do {
                            System.out.print("¿Desea agregar otro producto? (sí/no): ");
                            respuesta = scanner.nextLine().trim().toLowerCase();
                            if (!respuesta.equals("si") && !respuesta.equals("no")) {
                                System.out.println("Respuesta no válida. Por favor, ingrese 'si' o 'no'.");
                            }
                        } while (!respuesta.equals("si") && !respuesta.equals("no"));

                        if (respuesta.equals("no")) {
                            break;
                        }
                    }
                    break;

                case 2:
                    // Realizar ventas
                    while (true) {
                        System.out.print("Ingrese el nombre del producto para vender: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la cantidad a vender: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();

                        inventario.venderProducto(nombre, cantidad);

                        String respuesta;
                        do {
                            System.out.print("¿Desea vender otro producto? (sí/no): ");
                            respuesta = scanner.nextLine().trim().toLowerCase();
                            if (!respuesta.equals("si") && !respuesta.equals("no")) {
                                System.out.println("Respuesta no válida. Por favor, ingrese 'si' o 'no'.");
                            }
                        } while (!respuesta.equals("si") && !respuesta.equals("no"));

                        if (respuesta.equals("no")) {
                            break;
                        }
                    }
                    break;

                case 3:
                    // Mostrar información del inventario
                    inventario.mostrarInventario();
                    break;

                case 4:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
            }
        }
    }
}
