package functions;

import java.util.function.BiFunction;

public class FunctionsAsArguments {
    protected static class MyMath{
        public static Integer add(Integer x, Integer y) {
            return x + y;
        }
        public static Integer subtract(Integer x, Integer y) {
            return x - y;
        }
        public static Integer computeIntegers(BiFunction<Integer, Integer, Integer> f,
                                              Integer input1, Integer input2) {
            return f.apply(input1, input2);
        }
    }
    public static void main(String[] args) {
        System.out.println(MyMath.computeIntegers(MyMath::add,10,8));
        System.out.println(MyMath.computeIntegers(MyMath::subtract,10,8));
        System.out.println(MyMath.computeIntegers((x, y) -> 2*x + 2*y, 10, 20));
    }
}
