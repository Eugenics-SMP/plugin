package lol.subhuman.eugenics.entity.effect;

public abstract class CustomEffect {
    protected final String name;
    protected final int duration; // in ticks

    protected CustomEffect(final String name, final int duration) {
        this.name = name;
        this.duration = duration;
    }
}
