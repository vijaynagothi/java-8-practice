package academy.elqoo.java8.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collects Characters from a string to a String
 */
public class CharacterToStringCollector implements Collector<Character, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, Character> accumulator() {
        return StringBuilder::append;
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb1, sb2) -> sb1.append(sb2);
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return StringBuilder::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(Collections.emptySet());
    }
}
