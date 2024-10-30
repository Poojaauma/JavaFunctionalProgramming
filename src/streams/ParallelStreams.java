package streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreams {
    public static void main(String[] args) {
        String[] words = {"hello", "world", "is", "cool"};
        List<String> wordsList = Arrays.asList(words);

        /**
         * Output:
         * Uppercasing
         * Uppercasing
         * Adding !
         * Adding !
         * Uppercasing
         * Adding !
         * Uppercasing
         * Adding !
         * [HELLO!, WORLD!, IS!, COOL!]
         */
        List<String> processedWords = wordsList.parallelStream()
                .map(word -> {
                    System.out.println("Uppercasing");
                    return word.toUpperCase();
                })
                .map(word -> {
                    System.out.println("Adding !");
                    return word+"!";
                })
                .toList();

        System.out.println(processedWords);
    }
}
