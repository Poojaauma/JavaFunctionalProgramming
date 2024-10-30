package functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {
    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divide = (x,y) -> x/y;
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> zeroCheck =
                (func) -> (x,y) -> {
                    if(y == 0f) {
                        System.out.println("Error second arg is zero");
                        return 0f;
                    }
                    return func.apply(x,y);
                } ;
        BiFunction<Float, Float, Float> safeDivision = zeroCheck.apply(divide);
        System.out.println(safeDivision.apply(1.0f, 0f));
    }
}
