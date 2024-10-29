import java.util.function.Function;

public class FunctionInterface {
    protected static class Multiplier {
        public static Integer triple(Integer num) {
            return num * 3;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> multiplier = Multiplier::triple;
        System.out.println(multiplier.apply(5));
    }
}
