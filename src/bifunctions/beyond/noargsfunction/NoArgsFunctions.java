package bifunctions.beyond.noargsfunction;

public class NoArgsFunctions {
    public static void main(String[] args) {
        NoArgsFunction<String> sayHello = () -> "Hello World";
        System.out.println(sayHello.apply());
    }
}
