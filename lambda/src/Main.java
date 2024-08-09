import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String frase = "ejemplo de frase con palabra ejemplo palabra palabra";

        System.out.println("Frase original: " + frase);

       /* Consumer<String> mostRepeatedWord = (String text) -> {
            text = text.replace(",", " ")
                    .replace(".", " ")
                    .replace(";", " ")
                    .replace(":", " ");
            String[] words = text.split(" ");
            int max = 0;
            String mostRepeated = "";
            for (String word : words) {
                int count = 0;
                for (String word2 : words) {
                    if (word.equals(word2)) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    mostRepeated = word;
                }
            }
            System.out.println("Palabra más repetida: " + mostRepeated);
            System.out.println("Número de veces que se repite: " + max);
        };*/
        //mostRepeatedWord.accept(frase);
        Consumer<String> mostrarPalabraMasRepetida = (texto) -> {
            String palabraMasRepetida = Arrays.stream(texto.split(" "))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                    .entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse("No hay palabras repetidas");
            System.out.println("La palabra más repetida es: " + palabraMasRepetida);
            System.out.println("Número de veces que se repite: " + Arrays.stream(texto.split(" "))
                    .filter(s -> s.equals(palabraMasRepetida))
                    .count());
        };
        mostrarPalabraMasRepetida.accept(frase);

    }
}