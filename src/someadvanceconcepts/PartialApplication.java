package someadvanceconcepts;

import functions.beyond.trifunction.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialApplication {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        System.out.println(sum.apply(1, 2, 3));

        //Way 1:
        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
                (x) -> (y,z) -> sum.apply(x, y, z);
        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);
        System.out.println(add5.apply(6, 7));

        //Way 2:
        BiFunction<Integer, Integer, Function<Integer, Integer>> addPartial2 =
                (x,y) -> (z) -> sum.apply(x, y, z);
        Function<Integer, Integer> add5And6 = addPartial2.apply(5, 6);
        System.out.println(add5And6.apply(7));


    }
}
