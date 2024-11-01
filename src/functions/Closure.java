package functions;

import functions.beyond.noargsfunction.NoArgsFunction;

/**
 * Closure means when a function that returns another function
 * , the function that we return still has access to that internal scope
 */
public class Closure {
    public static void main(String[] args) {
        NoArgsFunction<NoArgsFunction<String>> createGreeter = () -> {
            String name = "Uma";
            return () -> "Hello " + name;
        };
        NoArgsFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());
    }
}
