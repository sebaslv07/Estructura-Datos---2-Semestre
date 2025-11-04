package webBrowserHistory;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final Stack<String> historial = new Stack<>();
    private static final Scanner scan = new Scanner(System.in);


    private static void mostrarEncabezado() {
        if (historial.isEmpty()) {
            System.out.println("\nNo hay sitio actual");
        } else {
            System.out.println("\nSitio actual: " + historial.peek());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Visitar sitio web");
        System.out.println("2. Volver al sitio anterior");
        System.out.println("3. Buscar en el historial");
        System.out.println("4. Ver sitio actual y cantidad de sitios");
        System.out.println("5. Salir");
        System.out.print("Elige una opción (1-5): ");
    }

    private static boolean procesarOpcion(String opcion) {
        switch (opcion) {
            case "1":
                visitarSitio();
                break;
            case "2":
                volverSitio();
                break;
            case "3":
                buscarEnHistorial();
                break;
            case "4":
                mostrarActualYCantidad();
                break;
            case "5":
                System.out.println("Saliendo...");
                return false;
            default:
                System.out.println("Opcion no valida");
        }
        return true;
    }

    private static void visitarSitio() {
        System.out.print("Ingresa la URL del sitio: ");
        String sitio = scan.nextLine().trim();
        if (sitio.isEmpty()) {
            System.out.println("URL no valida");
        } else {
            historial.push(sitio);
            System.out.println("Visitaste: " + sitio);
        }
    }

    private static void volverSitio() {
        if (historial.isEmpty()) {
            System.out.println("No hay historial");
            return;
        }
        String sitioAnterior = historial.pop();
        System.out.println("Regresaste desde: " + sitioAnterior);
        if (!historial.isEmpty()) {
            System.out.println("Sitio actual: " + historial.peek());
        } else {
            System.out.println("Historial vacio");
        }
    }

    private static void buscarEnHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay historial");
            return;
        }

        System.out.print("Ingresa el nombre o URL a buscar: ");
        String busqueda = scan.nextLine().trim();

        if (busqueda.isEmpty()) {
            System.out.println("Entrada no valida");
            return;
        }

        boolean encontrado = historial.contains(busqueda);
        if (!encontrado) {
            System.out.println("No se encontro: " + busqueda);
            return;
        }

        System.out.println("Se encontro en el historial: " + busqueda);
        System.out.print("¿Deseas entrar a este sitio? (s/n): ");
        String decision = scan.nextLine().trim().toLowerCase();

        if (decision.equals("s")) {
            historial.push(busqueda);
            System.out.println("Entraste al sitio: " + busqueda);
        } else {
            if (historial.isEmpty()) {
                System.out.println("No hay sitio actual");
            } else {
                System.out.println("Sigues en el sitio actual: " + historial.peek());
            }
        }
    }

    private static void mostrarActualYCantidad() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacio");
            System.out.println("Numero de sitios visitados: 0");
        } else {
            System.out.println("Sitio actual: " + historial.peek());
            System.out.println("Numero de sitios visitados: " + historial.size());
        }
    }

    
    public static void main(String[] args) {
        boolean navegando = true;

        while (navegando) {
            mostrarEncabezado();
            mostrarMenu();
            String opcion = scan.nextLine().trim();
            navegando = procesarOpcion(opcion);
        }

        scan.close();
    }
}