package lol.subhuman.eugenics.entity.player.champion.ability.special;

import lol.subhuman.eugenics.EugenicsPlugin;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import org.bukkit.scheduler.BukkitTask;

import java.util.function.Supplier;

public abstract class AbstractSpecialAbility {
    protected final String name;
    protected final Supplier<String> description;
    protected final int requiredCharge;
    protected final PlayerContext owner;
    protected int level;

    protected boolean isActive;
    protected BukkitTask currentTask;

    protected AbstractSpecialAbility(final PlayerContext owner, final int requiredCharge, final String name, final Supplier<String> description) {
        this.name = name;
        this.owner = owner;
        this.requiredCharge = requiredCharge;
        this.description = description;
        this.level = 1;

        this.isActive = false;
    }

    public abstract void use(final EugenicsPlugin plugin,
                             final PlayerContext playerContext);

    public void deactivate() {
        if (currentTask != null) {
            currentTask.cancel();
            currentTask = null;
        }
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}
