package pl.ttpsc.javaupdate.project;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class CustomSpliterator<T> extends Spliterators.AbstractSpliterator<T> {
    private final Spliterator<T> sourceSpliterator;

    public CustomSpliterator(Spliterator<T> source) {
        super(source.estimateSize(), source.characteristics());
        this.sourceSpliterator = source;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        return sourceSpliterator.tryAdvance(element -> {
            // Modify or process the element as needed
            action.accept(element);
        });
    }
}
