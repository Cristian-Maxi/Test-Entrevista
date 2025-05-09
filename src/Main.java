import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> numeros = IntStream.rangeClosed(1, 1_000_000).boxed().toList();

        long inicioStream = System.currentTimeMillis();
        List<Integer> primosStream = hallarPrimosStream(numeros);
        long finStream = System.currentTimeMillis();
        System.out.println("Tiempo con Streams: " + (finStream - inicioStream) + " ms");
        System.out.println("Primos Stream encontrados: " + primosStream.size());

        long inicioLoop = System.currentTimeMillis();
        List<Integer> primosLoop = hallarPrimosFor(numeros);
        long finLoop = System.currentTimeMillis();
        System.out.println("Tiempo con bucle clásico: " + (finLoop - inicioLoop) + " ms");
        System.out.println("Primos For encontrados: " + primosLoop.size());
    }

        public static List<Integer> hallarPrimosStream(List<Integer> numeros) {
            return numeros.stream()
                    .filter(Main::esPrimoStream)
                    .collect(Collectors.toList());
        }

        private static boolean esPrimoStream(int numero) {
            if (numero < 2) return false;
            return IntStream.rangeClosed(2, (int) Math.sqrt(numero))
                    .noneMatch(div -> numero % div == 0);
        }

        public static List<Integer> hallarPrimosFor(List<Integer> numeros) {
            List<Integer> primos = new ArrayList<>();
            for (int numero : numeros) {
                if (esPrimoFor(numero)) {
                    primos.add(numero);
                }
            }
            return primos;
        }

        private static boolean esPrimoFor(int numero) {
            if (numero < 2) return false;
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) return false;
            }
            return true;
        }

}
