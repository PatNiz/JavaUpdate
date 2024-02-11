package pl.ttpsc.javaupdate.project;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamsAdvance {

    //FlatMap
    public static <T> List<T> getNonNullListOfWords(List<T> list, Function<T, Stream<T>> mapper) {
        return list.stream()
                .flatMap(element -> element != null ? mapper.apply(element) : Stream.empty())
                .collect(Collectors.toList());
    }
//mapMulti to metoda wprowadzona w Javie 16,
// która pozwala na wielokrotne mapowanie (multiple mapping) elementów strumienia.
// Działa na zasadzie przekazywania wartości do konsumenta, który może akceptować więcej niż jedną wartość dla danego elementu wejściowego.
    public static void mapMultiExample() {
        IntStream.rangeClosed(1, 5)
                .mapMulti((num, consumer) -> {
                    consumer.accept(num * 2);
                    consumer.accept(num * 2 + 1);
                })
                .forEach(System.out::print);
    }

    public static void spliteratorExample() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Spliterator<Integer> customSpliterator = new CustomSpliterator<>(stream.spliterator());

        Stream<Integer> customStream = StreamSupport.stream(customSpliterator, false);
        customStream.forEach(System.out::println);
    }
}
