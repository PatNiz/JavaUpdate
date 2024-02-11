package pl.ttpsc.javaupdate.project.entity;

public class CharsOperations {
    public static void printSentence(){
        String sentence ="Hello world!";
        sentence.chars().forEach(s -> System.out.print((char)s));
        System.out.println("");
        sentence.chars().parallel().forEach(s -> System.out.print((char)s));
        System.out.println("");
        sentence.chars().parallel().forEachOrdered(s -> System.out.print((char)s));
    }
    public static void main(String[] args) {
        printSentence();
    }
}
