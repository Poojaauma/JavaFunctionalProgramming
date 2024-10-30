package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapInStreams {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(intArray));
        List<Integer> doubledIntArray = integerList.stream()
                .map(x -> x*2)
                .toList();
        System.out.println(doubledIntArray);
    }
}
