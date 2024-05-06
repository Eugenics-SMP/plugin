package lol.subhuman.eugenics.entity.player.champion.ability.special;

import lol.subhuman.eugenics.entity.player.PlayerContext;

import java.util.function.Supplier;

public abstract class AbstractSpecialAbility {
    protected final String name;
    protected final Supplier<String> description;
    protected final int requiredCharge;
    protected final PlayerContext owner;
    protected int level;

    protected AbstractSpecialAbility(final PlayerContext owner, final int requiredCharge, final String name, final Supplier<String> description) {
        this.name = name;
        this.owner = owner;
        this.requiredCharge = requiredCharge;
        this.description = description;
        this.level = 1;
    }

    public abstract void use(final PlayerContext playerContext);
}
