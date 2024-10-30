package functions;

import java.util.function.Function;

public class ReturningFunctions {
    protected static class MyMath {
        //Instead of the below methods
        public static Integer timesTwo(Integer x) {
            return x * 2;
        }
        public static Integer timesThree(Integer x) {
            return x * 3;
        }
        public static Integer timesFour(Integer x) {
            return x * 4;
        }
        //Use the below, so that we can make our code extensible
        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return x -> x * y;
        }
    }
    public static void main(String[] args) {
        System.out.println(MyMath.createMultiplier(5).apply(5));
    }
}
