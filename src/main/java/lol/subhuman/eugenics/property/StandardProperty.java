package lol.subhuman.eugenics.property;

import lol.subhuman.eugenics.property.bindings.IProperty;

public class StandardProperty<T> implements IProperty<T> {
    private final String name;
    private T value;

    public StandardProperty(final String name, final T value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(final T value) {
        this.value = value;
    }
}
