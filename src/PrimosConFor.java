import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimosConFor {

    public static List<Integer> hallarPrimos(List<Integer> numeros) {
        List<Integer> primos = new ArrayList<>();
        for (int numero : numeros) {
            if (esPrimo(numero)) {
                primos.add(numero);
            }
        }
        return primos;
    }

    private static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> numeros = IntStream.rangeClosed(1, 1_000_000).boxed().toList();
        List<Integer> primos = hallarPrimos(numeros);
        System.out.println("Cantidad de primos: " + primos.size());
    }
}
