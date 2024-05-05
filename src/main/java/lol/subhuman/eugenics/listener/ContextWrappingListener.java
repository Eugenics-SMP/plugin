package lol.subhuman.eugenics.listener;

import lol.subhuman.eugenics.entity.CustomEntityContext;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.repository.bindings.IEntityContextRepository;
import lol.subhuman.eugenics.entity.repository.bindings.IPlayerContextRepository;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityRemoveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class ContextWrappingListener implements Listener {
    private final IEntityContextRepository entityRepository;
    private final IPlayerContextRepository playerRepository;

    public ContextWrappingListener(final IEntityContextRepository entityRepository,
                                   final IPlayerContextRepository playerRepository) {
        this.entityRepository = entityRepository;
        this.playerRepository = playerRepository;
    }

    @EventHandler
    public void onCreatureSpawn(final CreatureSpawnEvent event) {
        final LivingEntity entity = event.getEntity();
        final CustomEntityContext context = new CustomEntityContext(entity);

        entityRepository.cacheContext(context);
    }

    @EventHandler
    public void onCreatureDeath(final EntityDeathEvent event) {
        final LivingEntity entity = event.getEntity();

        if (!(entity instanceof Player)) {
            entityRepository.removeContext(entity);
        }
    }

    @EventHandler
    public void onEntityRemove(final EntityRemoveEvent event) {
        if (event.getEntity() instanceof final LivingEntity entity) {
            if (!(entity instanceof Player)) {
                entityRepository.removeContext(entity);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final PlayerContext context = new PlayerContext(player);
        playerRepository.cacheContext(context);
    }

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        playerRepository.removeContext(player.getUniqueId());
    }
}
