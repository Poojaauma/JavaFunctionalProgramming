package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CombineListFunctions {
    protected record Employee(String name, Float salary, String designation, Integer age) { }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("A",200000f, "Dev", 25),
                new Employee("B",150000f, "QAE", 24),
                new Employee("C",300000f, "PM", 27),
                new Employee("D",500000f, "SDM", 29),
                new Employee("E",200000f, "Dev", 30)
        };
        List<Employee> employeeList = Arrays.asList(employees);

        Float totalDevSalary = employeeList.stream()
                .filter(employee -> employee.designation.equals("Dev"))
                .map(dev -> dev.salary)
                .reduce(0f, Float::sum);

        System.out.println(totalDevSalary); //400000.0

        //Average salary based on designation
        /**
         * Output:
         * {QAE=150000.0, Dev=200000.0, SDM=500000.0, PM=300000.0}
         */
        Map<String, Float> avgSalaries = employeeList.stream()
                .collect(Collectors.groupingBy(emp -> emp.designation))
                .entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().map(emp -> emp.salary).reduce(0f, Float::sum)/ entry.getValue().size()
                ));
        System.out.println(avgSalaries);

    }
}
