package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectInStreams {
    public static void main(String[] args) {
        String[] words = {"hello", "world", "is", "cool"};
        List<String> wordsList = Arrays.asList(words);

        //hello-world
        System.out.println(
                wordsList.stream()
                        .filter(str -> str.length() > 4)
                        .collect(Collectors.joining("-")));

        // Frequency of words
        //{world=1, hello=1}
        System.out.println(
                wordsList.stream()
                        .filter(str -> str.length() > 4)
                        .collect(Collectors.groupingBy(str -> str, Collectors.counting())));


        //{false=[is], true=[hello, world, cool]}
        System.out.println(
                wordsList.stream()
                        .filter(str -> !str.isEmpty())
                        .collect(Collectors.partitioningBy(word -> word.length() > 3)));

        // {2=[is], 4=[cool], 5=[hello, world]}
        System.out.println(
                wordsList.stream()
                        .filter(str -> !str.isEmpty())
                        .collect(Collectors.groupingBy(String::length)));

        //2
        System.out.println(
                wordsList.stream()
                        .filter(str -> str.length() > 4)
                        .collect(Collectors.counting())); // Can be replaced with .count()
    }
}
