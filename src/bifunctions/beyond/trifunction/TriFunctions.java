package bifunctions.beyond.trifunction;

public class TriFunctions {
    public static void main(String[] args) {
        TriFunction<String, String, String, String> concatThreeStrings
                = (a,b,c) -> a + b + c;
        System.out.println(concatThreeStrings.apply("aaa", "bbb", "ccc"));
    }
}
