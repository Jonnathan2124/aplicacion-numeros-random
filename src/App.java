import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tamaños = {10, 100, 1000, 5000, 10000, 30000};
        int rango = 30000;

        int[][] arreglos = Utilidades.generarArreglos(tamaños, rango);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Generar Arreglos aleatorios con diferente tamaño");
            System.out.println("2. Ordenar por los 4 métodos");
            System.out.println("3. Buscar valores con búsqueda binaria normal y recursiva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("\nArreglos generados:");
                for (int i = 0; i < tamaños.length; i++) {
                    System.out.println("Tamaño " + tamaños[i] + ": " + java.util.Arrays.toString(arreglos[i]));
                }
            } else if (opcion == 2) {
                Utilidades.ordenarArreglos(arreglos, tamaños);
            } else if (opcion == 3) {
                Utilidades.buscarValores(arreglos, tamaños);
            } else if (opcion == 4) {
                System.out.println("Saliendo del programa...");
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}