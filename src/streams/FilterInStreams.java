package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterInStreams {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(intArray));

        List<Integer> evens = integerList.stream()
                .filter(x -> x % 2 == 0)
                .toList();
        List<Integer> odds = integerList.stream()
                .filter(x -> x  % 2 == 1).toList();

        System.out.println(evens);
        System.out.println(odds);

        //Passing Predicates as parameters to functions
        String[] words = {"hello", "world", "is", "cool"};
        List<String> wordsList = Arrays.asList(words);
        Function<Integer, Predicate<String>> createLengthCheck
                = minLen -> str -> str.length() > minLen;
        System.out.println(
                wordsList.stream()
                        .filter(createLengthCheck.apply(4))
                        .toList());

    }
}
