package lol.subhuman.eugenics.entity.effect;

public abstract class CustomEffect {
    // TODO: make it so that some effects can be cancelled ? Has to keep track of the owner though, if there are any.
    // TODO: For player contexts, add healing handlers.
    // TODO: Damage types must be abstracted into classes, not enums. The reason is because, for example, a DamageContext
    // tells the player being attacked to do x3 knockback, but the player being attacked might have some knockback resistance
    
    protected final String name;
    protected final int duration; // in ticks
    // protected final List<PlayerContext> effectOwners;

    protected CustomEffect(final String name, final int duration) { // final PlayerCOntext... owners
        this.name = name;
        this.duration = duration;
        // this.effectOwners = new ArrayList<>(owners);
    }

    /*
    public final List<PlayerContext> getOwners() {
        return this.effectOwners;
    }
    */
}
