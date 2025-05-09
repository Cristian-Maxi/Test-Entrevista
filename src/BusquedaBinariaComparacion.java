import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class BusquedaBinariaComparacion {

    public static void main(String[] args) {
        List<Integer> listaOrdenada = IntStream.rangeClosed(1, 1_000_000).boxed().toList();
        int valorBuscado = 999_999;

        long inicioLoop = System.nanoTime();
        int indiceLoop = buscarElementoForLoop(listaOrdenada, valorBuscado);
        long finLoop = System.nanoTime();
        System.out.println("Búsqueda binaria clásica: " + "Elemento encontrado en " + (finLoop - inicioLoop) / 1_000_000.0 + " ms");

        long inicioStream = System.nanoTime();
        Optional<Integer> resultadoStream = buscarElementoStream(listaOrdenada, valorBuscado);
        long finStream = System.nanoTime();
        System.out.println("Búsqueda con Stream: " + "Elemento encontrado en " + (finStream - inicioStream) / 1_000_000.0 + " ms");
    }

    // Implementación clásica con búsqueda binaria
    public static int buscarElementoForLoop(List<Integer> lista, int valorBuscado) {
        int izquierda = 0;
        int derecha = lista.size() - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (lista.get(medio) == valorBuscado) return medio;
            if (lista.get(medio) < valorBuscado) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }

    // Implementación con Streams
    public static Optional<Integer> buscarElementoStream(List<Integer> lista, int valorBuscado) {
        return lista.stream()
                .filter(n -> n == valorBuscado)
                .findFirst();
    }
}
