import bifunctions.beyond.noargsfunction.NoArgsFunction;

public class FunctionsAsData {
    protected static class Person{
        private String name;
        private int age;
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader{
        public final NoArgsFunction<Person> loadPerson;
        public DataLoader(Boolean isDevelopment){
            this.loadPerson = isDevelopment ? this::loadPersonFake : this::loadPersonReal;
        }
        private Person loadPersonReal() {
            System.out.println("Loading Person Real");
            return new Person("Real Person", 18);
        }

        private Person loadPersonFake() {
            System.out.println("Loading Person Fake");
            return new Person("Fake Person", 1000);
        }
    }
    public static void main(String[] args) {
        final boolean isDevelopment = false;
        DataLoader dataLoader = new DataLoader(isDevelopment);
        System.out.println(dataLoader.loadPerson.apply());
    }
}
