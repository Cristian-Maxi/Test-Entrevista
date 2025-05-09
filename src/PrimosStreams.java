import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimosStreams {

    public static List<Integer> hallarPrimos(List<Integer> numeros) {
        return numeros.stream()
                .filter(PrimosStreams::esPrimo)
                .collect(Collectors.toList());
    }

    private static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(numero))
                .noneMatch(div -> numero % div == 0);
    }

    public static void main(String[] args) {
        List<Integer> numeros = IntStream.rangeClosed(1, 1_000_000).boxed().toList();
        List<Integer> primos = hallarPrimos(numeros);
        System.out.println("Cantidad de primos: " + primos.size());
    }
}