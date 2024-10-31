package someadvanceconcepts;

import streams.CombineListFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Composition {
    protected record Employee(String name, Float salary, String designation, Integer age) { }


    public static void main(String[] args) {
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> minusOne = x -> x - 1;

        //Compose
        // Works in reverse order i.e. First minusOne is executed and then timesTwo
        //Output: 18
        Function<Integer, Integer> timesTwoMinusOne = timesTwo.compose(minusOne);
        System.out.println(timesTwoMinusOne.apply(10));

        Function<Integer, Integer> timesTwoMinusOne_ = timesTwo.andThen(minusOne);
        System.out.println(timesTwoMinusOne_.apply(10));

        Employee[] employees = {
                new Employee("AdC",200000f, "Dev", 25),
                new Employee("BdC",150000f, "QAE", 24),
                new Employee("CeR",300000f, "PM", 27),
                new Employee("DwA",500000f, "SDM", 29),
                new Employee("EqA",200000f, "Dev", 30)
        };
        List<Employee> employeeList = Arrays.asList(employees);
        Function<Employee, String> getName = employee -> employee.name;
        Function<String, String> rev = str -> new StringBuilder(str).reverse().toString();
        Function<String, String> upperCase = String::toUpperCase;

        Function<Employee, String> getReversedUpperCaseName = getName.andThen(upperCase).andThen(rev);
        List<String> results = employeeList.stream().map(getReversedUpperCaseName).toList();
        System.out.println(results);
    }
}
