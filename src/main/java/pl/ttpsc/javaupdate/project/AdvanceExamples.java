package pl.ttpsc.javaupdate.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AdvanceExamples {
    public static void main(String[] args) {
        //List<String> wordsWithNull = List.of("apple", null, "banana", null, "cherry"); -> List.of nie przyjmuje null od Java 9
        List<String> wordsWithNull = Arrays.asList("apple", null, "banana", null, "cherry");
        System.out.println(StreamsAdvance.getNonNullListOfWords(wordsWithNull,word -> word != null ? Arrays.stream(word.split("")) : Stream.empty()));
        StreamsAdvance.mapMultiExample();
        //StreamsAdvance.spliteratorExample();
    }
}
