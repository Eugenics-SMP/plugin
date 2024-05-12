package lol.subhuman.eugenics.entity.effect;

import lol.subhuman.eugenics.entity.CustomEntityContext;

public abstract class CustomEffect {
    protected final String name;
    protected int duration; // in ticks
    protected final double intensity;

    protected CustomEffect(final String name, final int duration, final double intensity) {
        this.name = name;
        this.duration = duration;
        this.intensity = intensity;
    }

    public abstract void apply(final CustomEntityContext context);

    public abstract void remove(final CustomEntityContext context);

    public void tick(final CustomEntityContext context) {
        if (this.duration > 0) {
            apply(context);
            this.duration--;
        } else {
            remove(context);
        }
    }

    public boolean isActive() {
        return duration > 0;
    }
}
