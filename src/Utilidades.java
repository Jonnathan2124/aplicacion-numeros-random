import java.util.Random;

public class Utilidades {
    public static int[][] generarArreglos(int[] tamaños, int rango) {
        Random random = new Random();
        int[][] arreglos = new int[tamaños.length][];
        for (int i = 0; i < tamaños.length; i++) {
            arreglos[i] = new int[tamaños[i]];
            for (int j = 0; j < tamaños[i]; j++) {
                if (i > 0 && j < arreglos[i - 1].length) {
                    arreglos[i][j] = arreglos[i - 1][j];
                } else {
                    arreglos[i][j] = random.nextInt(rango) + 1;
                }
            }
        }
        return arreglos;
    }

    public static void ordenarArreglos(int[][] arreglos, int[] tamaños) {
        for (int i = 0; i < tamaños.length; i++) {
            int tamaño = tamaños[i];
            int[] arregloOriginal = arreglos[i];

            System.out.println("\nOrdenando arreglo de tamaño: " + tamaño);

            int[] arregloBurbuja = arregloOriginal.clone();
            long inicioBurbuja = System.nanoTime();
            Ordenamiento.burbujaConAjuste(arregloBurbuja);
            long finBurbuja = System.nanoTime();
            System.out.println("Burbuja con ajuste: " + (finBurbuja - inicioBurbuja) + " nanosegundos");

            int[] arregloBurbujaSimple = arregloOriginal.clone();
            long inicioBurbujaSimple = System.nanoTime();
            Ordenamiento.burbuja(arregloBurbujaSimple);
            long finBurbujaSimple = System.nanoTime();
            System.out.println("Burbuja simple: " + (finBurbujaSimple - inicioBurbujaSimple) + " nanosegundos");

            int[] arregloSeleccion = arregloOriginal.clone();
            long inicioSeleccion = System.nanoTime();
            Ordenamiento.seleccion(arregloSeleccion);
            long finSeleccion = System.nanoTime();
            System.out.println("Selección: " + (finSeleccion - inicioSeleccion) + " nanosegundos");

            int[] arregloInsercion = arregloOriginal.clone();
            long inicioInsercion = System.nanoTime();
            Ordenamiento.insercion(arregloInsercion);
            long finInsercion = System.nanoTime();
            System.out.println("Inserción: " + (finInsercion - inicioInsercion) + " nanosegundos");
        }
    }

    public static void buscarValores(int[][] arreglos, int[] tamaños) {
        int[] valoresBusqueda = {9, 98, 957, 4000, 9876, 29475};

        for (int i = 0; i < tamaños.length; i++) {
            int[] arregloOrdenado = arreglos[i].clone();
            Ordenamiento.burbujaConAjuste(arregloOrdenado);
            int valor = valoresBusqueda[i];

            System.out.println("\nBuscando en arreglo de tamaño " + tamaños[i] + ": Valor " + valor);

            long inicioBinaria = System.nanoTime();
            int posicion = Busqueda.busquedaBinaria(arregloOrdenado, valor);
            long finBinaria = System.nanoTime();
            System.out.println("Búsqueda binaria normal: " + (finBinaria - inicioBinaria) + " nanosegundos. Posición: " + posicion);

            long inicioBinariaRec = System.nanoTime();
            posicion = Busqueda.busquedaBinariaRecursiva(arregloOrdenado, valor, 0, arregloOrdenado.length - 1);
            long finBinariaRec = System.nanoTime();
            System.out.println("Búsqueda binaria recursiva: " + (finBinariaRec - inicioBinariaRec) + " nanosegundos. Posición: " + posicion);
        }
    }
}

