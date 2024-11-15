public class Busqueda {
    public static int busquedaBinaria(int[] arreglo, int valor) {
        int inicio = 0, fin = arreglo.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arreglo[medio] == valor) return medio;
            if (arreglo[medio] < valor) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }

    public static int busquedaBinariaRecursiva(int[] arreglo, int valor, int inicio, int fin) {
        if (inicio > fin) return -1;
        int medio = inicio + (fin - inicio) / 2;
        if (arreglo[medio] == valor) return medio;
        if (arreglo[medio] < valor)
            return busquedaBinariaRecursiva(arreglo, valor, medio + 1, fin);
        else
            return busquedaBinariaRecursiva(arreglo, valor, inicio, medio - 1);
    }
}
