package lol.subhuman.eugenics.entity.repository;

import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.repository.bindings.IPlayerContextRepository;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public final class UUIDBoundPlayerContextRepository implements IPlayerContextRepository {
    private final Map<UUID, PlayerContext> playerContextMap;

    public UUIDBoundPlayerContextRepository(final Map<UUID, PlayerContext> playerContextMap) {
        this.playerContextMap = playerContextMap;
    }

    @Override
    public void cacheContext(final PlayerContext context) {
        final Player player = (Player) context.getBackingEntity();
        playerContextMap.put(player.getUniqueId(), context);
    }

    @Override
    public void removeContext(final UUID uuid) {
        playerContextMap.remove(uuid);
    }

    @Override
    public PlayerContext getContext(final Player context) {
        return playerContextMap.get(context.getUniqueId());
    }
}
