package lol.subhuman.eugenics.property.bindings;

public interface IClampedProperty<T extends Number> extends IProperty<T> {
    T getMin();

    T getMax();
}
