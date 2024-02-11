package pl.ttpsc.javaupdate.project;

import pl.ttpsc.javaupdate.project.entity.Car;
import pl.ttpsc.javaupdate.project.entity.Employee;
import pl.ttpsc.javaupdate.project.entity.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Streams {

    //Filtr
    //filter(Predicate<T> predicate): Pozwala na zachowanie tylko tych elementów, które spełniają określony warunek.
    public static List<Car> findCarsWithLowMileage(List<Car> allCars) {
        return allCars.stream().filter(car -> car.mileage() < 100000L).collect(Collectors.toList());
    }

    public static List<String> checkWordIsStartsWithA(List<String> words) {
        return words.stream().filter(word -> word.startsWith("a")).toList();
    }

    //Map
    //map(Function<T, R> mapper): Pozwala przekształcać każdy element strumienia za pomocą określonej funkcji.
    public static List<Integer> getWordsLength(List<String> words) {
        return words.stream().map(String::length).toList();
    }
    //FlatMap

    public static List<String> getPeopleInterestsFlatMap(List<Person> people) {
        return people.stream()
                .flatMap(person -> person.interests().stream())
                .collect(Collectors.toList());
    }
    //Sorted
    //sorted(): Sortuje elementy strumienia.
    //sorted(Comparator<T> comparator): Sortuje elementy strumienia przy użyciu określonego komparatora.
    public static List<String> sortWordsAlphabetically(List<String> words) {
        return words.stream().sorted().toList();
    }

    public static List<String> reverseOrderSortWords(List<String> words) {
        return words.stream().sorted(Comparator.reverseOrder()).toList();
    }

    //Reduce
    //reduce(T identity, BinaryOperator<T> accumulator): Redukuje elementy strumienia do jednego wyniku za pomocą określonego akumulatora.
    public static Integer sumElements(List<Integer> elements) {
        return elements.stream().reduce(0, Integer::sum);
    }
    /*
    Wartość początkową redukcji ustawiono na 0 w drugim argumencie metody reduce. To oznacza, że suma zaczyna się od wartości 0. Proces redukcji przebiega w następujący sposób:
    Wartość początkowa (identity): 0
    Akcja redukcyjna (accumulator): Integer::sum
    Elementy strumienia: 1, 2, 3, 4, 5
    Kroki redukcji:
    Iteracja 1: 0 + 1 = 1
    Iteracja 2: 1 + 2 = 3
    Iteracja 3: 3 + 3 = 6
    Iteracja 4: 6 + 4 = 10
    Iteracja 5: 10 + 5 = 15
     */
    public static Integer findMax(List<Integer> elements) {
        return elements.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }
    //Collect
    public static String joinStrings(List<String> strings) {
        return strings.stream()
                .collect(joining(", "));
    }
    public static List<String> getPeopleInterestsCollect(List<Person>people){
        return people.stream()
                .collect(Collectors.flatMapping(person -> person.interests().stream(), Collectors.toList()));
    }

    //GROUPING
    public static Map<Integer, List<String>> groupedByLength(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }




    public static Map<Integer,List<Person>> getGroupOfPeopleWithNameLengh(Integer lengh,List<Person> people){
        return people.stream().collect(Collectors.groupingBy(person -> person.name().length()));
    }
    // Grupowanie osób według długości ich imion
    public void printPeopleWithNameLengh(Map<Integer, List<Person>> groupedByLength) {
        groupedByLength.forEach((length, persons) -> {
            System.out.println("Osoby z imionem o długości " + length + ":");
            persons.forEach(person -> System.out.println("- " + person.name()));
            System.out.println();
        });
    }


    public static void dropWhileExample() {
        System.out.println("drop num<3");
        Stream.of(1, 2, 3, 4, 5)
                .dropWhile(num -> num < 3)
                .forEach(System.out::print);
        System.out.println();
    }
    public static void takeWhileExample() {
        System.out.println("take num <3");
        Stream.of(1, 2, 3, 4, 5)
                .takeWhile(num -> num < 3)
                .forEach(System.out::print);
        System.out.println();
    }
    public static String joiningWords(List<String> words){
        return words.stream().collect(joining(" "));
    }

    //Metoda peek w Java Stream API umożliwia wykonanie pewnych operacji na każdym elemencie strumienia bez wpływania na sam strumień
    // Jest to użyteczne do diagnostyki, debugowania lub wizualizacji operacji na elementach strumienia, ponieważ peek nie wpływa na strumień, a jedynie pozwala na "podgląd" każdego elementu.
    public static void peekExample() {
        Stream.of("apple", "banana", "cherry")
                .peek(word -> System.out.println("Processing: " + word))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static Map<String, List<Car>> groupByModel(List<Car> cars) {
        return cars.stream().collect(Collectors.groupingBy(Car::model));
    }
    //Parallel Streams:
    //
    //parallel(): Przekształca sekwencyjny strumień w równoległy, co pozwala na potencjalne przyspieszenie operacji na dużych zbiorach danych.
    public Integer getSum(List<Integer> numbers){
       return numbers.parallelStream()
                .reduce(0, Integer::sum);
    }
    public static String getAllNames(List<Employee> employees){
       return employees.stream().map(Employee::name).reduce((name,name1)-> name +"," + name1).get();
    }


    //distinct(): Pozwala na uzyskanie unikalnych elementów.
    public List<Integer> getUniqueList(List<Integer> numbers){
        return numbers.stream().distinct().collect(Collectors.toList());
    }

    //forEach(Consumer<T> action): Wykonuje określoną akcję dla każdego elementu strumienia.
    public void printInNewLine(List<String> words) {
        words.stream().forEach(System.out::println);
    }
    public String concatenatString(List<String> words) {
        return words.stream()
                .reduce("", (acc, word) -> acc.isEmpty() ? word : acc + " " + word);
    }
    public String collectAndThen(List<List<String>> listOfLists){
        return listOfLists.stream()
                .flatMap(List::stream) // Spłaszczanie listy list do jednego strumienia
                .collect(Collectors.collectingAndThen(joining(", "), str -> "[" + str + "]"));
    }

}
