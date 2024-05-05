package lol.subhuman.eugenics.entity.repository.bindings;

import lol.subhuman.eugenics.entity.CustomEntityContext;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface IPlayerContextRepository {
    void cacheContext(final PlayerContext context);

    void removeContext(final UUID uuid);

    PlayerContext getContext(final Player context);
}
