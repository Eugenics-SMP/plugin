package lol.subhuman.eugenics.entity.player.champion.ability.special.impl;

import lol.subhuman.eugenics.EugenicsPlugin;
import lol.subhuman.eugenics.entity.damage.DamageContext;
import lol.subhuman.eugenics.entity.damage.DamageType;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.champion.ability.special.AbstractSpecialAbility;
import lol.subhuman.eugenics.entity.repository.bindings.IEntityContextRepository;
import lol.subhuman.eugenics.entity.repository.bindings.IPlayerContextRepository;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public final class StarvedSpecialAbility extends AbstractSpecialAbility {
    private static final double BASE_RADIUS = 5.0;

    public StarvedSpecialAbility(final PlayerContext playerContext) {
        super(playerContext, 100, "Starved", () -> "");
    }

    @Override
    public void use(final EugenicsPlugin plugin,
                    final PlayerContext playerContext) {
        if (isActive) {
            playerContext.getBackingEntity().sendMessage("Ability is already active!");
            return;
        }

        final IPlayerContextRepository playerRepository = plugin.getPlayerRepository();

        isActive = true;

        currentTask = new BukkitRunnable() {
            private int ticks = 0;

            @Override
            public void run() {
                if (ticks >= 100) {
                    deactivate();
                    return;
                }

                playerContext.getBackingEntity().getNearbyEntities(15, 15, 15).stream()
                        .filter(e -> e instanceof Player)
                        .map(e -> (Player) e)
                        .forEach(target -> {
                            final PlayerContext targetContext = playerRepository.getContext(target);
                            final DamageContext damageContext = new DamageContext(10, false, DamageType.MAGIC);
                            targetContext.onAttacked(damageContext);
                        });

                spawnFireRing(playerContext.getBackingEntity().getLocation());

                ticks += 10;
            }
        }.runTaskTimer(plugin, 0L, 10L);
    }

    private void spawnFireRing(final Location center) {
        for (int i = 0; i < 360; i += 10) {
            final double angle = i * Math.PI / 180;
            final double x = center.getX() + BASE_RADIUS * Math.cos(angle);
            final double y = center.getY();
            final double z = center.getZ() + BASE_RADIUS * Math.sin(angle);
            final Location particleLocation = new Location(center.getWorld(), x, y, z);
            center.getWorld().spawnParticle(Particle.FLAME, particleLocation, 1, 0, 0, 0, 0);
        }
    }
}