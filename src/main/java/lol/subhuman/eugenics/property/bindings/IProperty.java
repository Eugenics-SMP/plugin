package lol.subhuman.eugenics.property.bindings;

public interface IProperty<T> {
    String getName();

    T getValue();

    void setValue(T value);
}
