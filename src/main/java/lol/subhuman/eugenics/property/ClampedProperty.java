package lol.subhuman.eugenics.property;

import lol.subhuman.eugenics.property.bindings.IClampedProperty;

public final class ClampedProperty<T extends Number> extends StandardProperty<T> implements IClampedProperty<T> {
    private final T min;
    private final T max;

    public ClampedProperty(final String name, final T value, final T min, final T max) {
        super(name, value);
        this.min = min;
        this.max = max;
    }

    @Override
    public T getMin() {
        return min;
    }

    @Override
    public T getMax() {
        return max;
    }
}
