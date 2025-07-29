import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;



public class TiendaVinilos {
    /**
     * Represnta el menú de nuestra tienda con todos sus submenus
     * autor Gonzalo
     * version 1.0
     */
}
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Vinilo> vinilos = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        clientes = cargarDatos("clientes.dat");
        vinilos = cargarDatos("vinilos.dat");
        ventas = cargarDatos("ventas.dat");

        int opcion = 0;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de vinilos");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Opción no válida.");
                continue;
            }

            switch (opcion) {
                case 1: menuClientes(); break;
                case 2: menuVinilos(); break;
                case 3: realizarVenta(); break;
                case 4: mostrarVentas(); break;
                case 5:
                    guardarDatos(clientes, "clientes.dat");
                    guardarDatos(vinilos, "vinilos.dat");
                    guardarDatos(ventas, "ventas.dat");
                    System.out.println("Saliendo... ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 5);
    }

    static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Alta de cliente");
            System.out.println("2. Baja de cliente");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Buscar cliente por DNI");
            System.out.println("5. Listar clientes");
            System.out.println("6. Volver al menú principal");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1: altaCliente(); break;
                case 2: bajaCliente(); break;
                case 3: modificarCliente(); break;
                case 4: buscarCliente(); break;
                case 5: listarClientes(); break;
            }
        } while (opcion != 6);
    }

    static void menuVinilos() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Vinilos ---");
            System.out.println("1. Alta de vinilo");
            System.out.println("2. Buscar vinilo por título");
            System.out.println("3. Listar catálogo");
            System.out.println("4. Volver al menú principal");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1: altaVinilo(); break;
                case 2: buscarVinilo(); break;
                case 3: listarVinilos(); break;
            }
        } while (opcion != 4);
    }

    static void altaCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        clientes.add(new Cliente(nombre, dni, telefono, email));
        System.out.println("Cliente añadido correctamente.");
    }

    static void bajaCliente() {
        System.out.print("Introduce el DNI del cliente a eliminar: ");
        String dni = sc.nextLine();
        clientes.removeIf(c -> c.getDni().equalsIgnoreCase(dni));
        System.out.println("Cliente eliminado (si existía).");
    }

    static void modificarCliente() {
        System.out.print("Introduce el DNI del cliente a modificar: ");
        String dni = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                System.out.print("Nuevo teléfono: ");
                c.setTelefono(sc.nextLine());
                System.out.print("Nuevo email: ");
                c.setEmail(sc.nextLine());
                System.out.println("Datos modificados.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    static void buscarCliente() {
        System.out.print("Introduce el DNI del cliente: ");
        String dni = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    static void listarClientes() {
        System.out.println("\n--- Lista de clientes ---");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    static void altaVinilo() {
        System.out.print("Título del vinilo: ");
        String titulo = sc.nextLine();

        System.out.print("Artista: ");
        String artista = sc.nextLine();

        double precio = 0;
        while (true) {
            System.out.print("Precio (usa punto como separador decimal, ej: 19.99): ");
            try {
                precio = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: introduce un número válido.");
            }
        }

        int stock = 0;
        while (true) {
            System.out.print("Cantidad en stock: ");
            try {
                stock = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: introduce un número entero.");
            }
        }

        vinilos.add(new Vinilo(titulo, artista, precio, stock));
        System.out.println("✅ Vinilo añadido correctamente.");
    }


    static void buscarVinilo() {
        System.out.print("Introduce el título del vinilo: ");
        String titulo = sc.nextLine();
        for (Vinilo v : vinilos) {
            if (v.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(v);
                return;
            }
        }
        System.out.println("Vinilo no encontrado.");
    }

    static void listarVinilos() {
        System.out.println("\n--- Catálogo de vinilos ---");
        for (Vinilo v : vinilos) {
            System.out.println(v);
        }
    }

    static void realizarVenta() {
        System.out.print("DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Fecha de la venta (dd/mm/aaaa): ");
        String fecha = sc.nextLine();
        Venta venta = new Venta(cliente, fecha);

        String mas;
        do {
            listarVinilos();
            System.out.print("Introduce título del vinilo a añadir: ");
            String titulo = sc.nextLine();
            for (Vinilo v : vinilos) {
                if (v.getTitulo().equalsIgnoreCase(titulo)) {
                    if (v.getStock() > 0) {
                        venta.añadirVinilo(v);
                        v.reducirStock();
                        System.out.println("Vinilo añadido a la venta.");
                    } else {
                        System.out.println("No hay stock disponible para este vinilo.");
                    }
                    break;
                }
            }
            System.out.print("¿Añadir otro vinilo? (s/n): ");
            mas = sc.nextLine();
        } while (mas.equalsIgnoreCase("s"));

        ventas.add(venta);
        System.out.println("Venta realizada con éxito. Total: " + venta.calcularTotal() + "€");
    }

    static void mostrarVentas() {
        System.out.println("\n--- Ventas realizadas ---");
        for (Venta v : ventas) {
            System.out.println(v);
        }

        // Mostrar total de ventas por cliente
        System.out.println("\n--- Total de ventas por cliente ---");
        HashMap<String, Double> totales = new HashMap<>();
        for (Venta v : ventas) {
            String dni = v.getCliente().getDni();
            double total = v.calcularTotal();
            totales.put(dni, totales.getOrDefault(dni, 0.0) + total);
        }
        for (String dni : totales.keySet()) {
            System.out.println("Cliente DNI: " + dni + " - Total Comprado: " + totales.get(dni) + "€");
        }
    }
