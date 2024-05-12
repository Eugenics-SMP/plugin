package lol.subhuman.eugenics.entity.player.champion.ability.special.impl;

import lol.subhuman.eugenics.EugenicsPlugin;
import lol.subhuman.eugenics.entity.damage.DamageContext;
import lol.subhuman.eugenics.entity.damage.DamageType;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.champion.ability.special.AbstractSpecialAbility;
import lol.subhuman.eugenics.entity.repository.bindings.IPlayerContextRepository;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class WrathSpecialAbility extends AbstractSpecialAbility {
    public WrathSpecialAbility(final PlayerContext owner) {
        super(owner, 100, "Wrath", () -> "Within a radius of A blocks, hit the highest HP player for B true damage.");
    }

    @Override
    public void use(final EugenicsPlugin plugin, final PlayerContext playerContext) {
        final IPlayerContextRepository playerRepository = plugin.getPlayerRepository();

        isActive = true;

        final float radius = this.getRadius();

        final List<Entity> nearbyEntities = playerContext.getBackingEntity().getNearbyEntities(radius, radius, radius);

        final Optional<Player> maxHealthPlayer = nearbyEntities.stream()
                .filter(Player.class::isInstance)
                .map(Player.class::cast)
                .max(Comparator.comparingDouble(player -> playerRepository.getContext(player).getHealth()));

        final PlayerContext targetContext = maxHealthPlayer.map(playerRepository::getContext).orElse(null);

        if (targetContext != null) {
            final DamageContext damageContext = new DamageContext(10, false, DamageType.MAGIC);
            targetContext.onAttacked(damageContext);
        }
    }

    private float getRadius() {
        return switch (this.level) {
            case 1, 2, 3 -> 4.5F;
            case 4 -> 5.5F;
            default -> 0F;
        };
    }
}
