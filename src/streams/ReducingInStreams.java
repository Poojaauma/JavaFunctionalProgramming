package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReducingInStreams {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(intArray));

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("Acc: " + acc + ", x: " + x + ", result: " + result);
            return result;
        };

        Integer sum = integerList.stream().reduce(0, getSum);
        System.out.println("Sum: " + sum);
    }
}
