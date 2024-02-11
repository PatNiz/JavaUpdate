package pl.ttpsc.javaupdate.project;

import pl.ttpsc.javaupdate.project.entity.Car;
import pl.ttpsc.javaupdate.project.entity.Employee;
import pl.ttpsc.javaupdate.project.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleExamples {
    public static void main(String[] args) {
        Car car1 = new Car(1L, "Toyota", "Camry", 200, 50000L);
        Car car2 = new Car(2L, "Honda", "Civic", 150, 700000L);
        Car car3 = new Car(2L, "Honda", "Civic", 170, 70000L);
        Car car4 = new Car(3L, "Ford", "Mustang", 300, 30000L);
        List<Person> people = Arrays.asList(
                new Person("Alice", Arrays.asList("Java", "Reading")),
                new Person("Bob", Arrays.asList("Cycling", "Cooking")),
                new Person("Charlie", Arrays.asList("Golf", "Music"))
        );
        System.out.println(Streams.findCarsWithLowMileage(Stream.of(car1, car2, car3).toList()));
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10);
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana", "cherry"),
                Arrays.asList("date", "elderberry", "fig"),
                Arrays.asList("grape", "honeydew", "kiwi")
        );
        List<Employee> employees = Arrays.asList(
                new Employee("name","sirname"),
                new Employee("name1","sirname1"),
                new Employee("name2","sirname2"));

        System.out.println(Streams.checkWordIsStartsWithA(words));
        System.out.println(Streams.getWordsLength(words));
        System.out.println(Streams.sortWordsAlphabetically(words));
        System.out.println(Streams.sumElements(numbers));
        System.out.println(Streams.findMax(numbers));
        System.out.println(Streams.groupByModel(Stream.of(car1, car2, car3,car4).toList()));


        Streams.takeWhileExample();
        Streams.dropWhileExample();
        Streams.peekExample();
        System.out.println(Streams.getAllNames(employees));
    }
}
