package lol.subhuman.eugenics.entity.player.champion.ability.passive;

import lol.subhuman.eugenics.entity.player.PlayerContext;
import org.bukkit.event.Event;

import java.util.function.Supplier;

public abstract class AbstractPassiveAbility {
    protected final String name;
    protected final Supplier<String> description;

    protected final PlayerContext playerContext;

    protected AbstractPassiveAbility(final String name, final Supplier<String> description, final PlayerContext playerContext) {
        this.name = name;
        this.description = description;
        this.playerContext = playerContext;
    }

    public abstract void handleEvent(final Event event);

    public abstract boolean shouldTrigger(final Event event);
}
