package io.vilya.common.function;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author iamaprin
 * @since 2018年6月28日 下午9:31:43
 * @see <a href="https://github.com/iluwatar/java-design-patterns/tree/master/converter">converter</a>
 */
public class Converter<T, U> {

    private final Function<T, U> fromLeft;

    private final Function<U, T> fromRight;

    public Converter(final Function<T, U> fromLeft, final Function<U, T> fromRight) {
        this.fromLeft = fromLeft;
        this.fromRight = fromRight;
    }

    public final U convertFromLeft(final T dto) {
        return fromLeft.apply(dto);
    }

    public final T convertFromRight(final U entity) {
        return fromRight.apply(entity);
    }

    public final List<U> createFromLeft(final Collection<T> dtos) {
        return dtos.stream().map(this::convertFromLeft).collect(Collectors.toList());
    }

    public final List<T> createFromERight(final Collection<U> entities) {
        return entities.stream().map(this::convertFromRight).collect(Collectors.toList());
    }

}
