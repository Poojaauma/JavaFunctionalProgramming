package functions.beyond.bifunction;

import java.util.function.BiFunction;

public class BiFunctions {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a * b;
        System.out.println(add.apply(1, 2));
    }
}
