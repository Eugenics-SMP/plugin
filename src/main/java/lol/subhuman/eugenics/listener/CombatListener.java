package lol.subhuman.eugenics.listener;

import lol.subhuman.eugenics.entity.CustomEntityContext;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeContext;
import lol.subhuman.eugenics.entity.repository.bindings.IEntityContextRepository;
import lol.subhuman.eugenics.entity.repository.bindings.IPlayerContextRepository;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class CombatListener implements Listener {
    private final IEntityContextRepository entityRepository;
    private final IPlayerContextRepository playerRepository;

    public CombatListener(final IEntityContextRepository entityRepository, final IPlayerContextRepository playerRepository) {
        this.entityRepository = entityRepository;
        this.playerRepository = playerRepository;
    }

    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        final Entity a = event.getDamager();
        final Entity b = event.getEntity();

        if (a instanceof final LivingEntity attacker && b instanceof final LivingEntity attacked) {
            if (attacked instanceof final Player player) {
                final PlayerContext playerContext = playerRepository.getContext(player);
                final PhenotypeContext<?> phenotypeContext = playerContext.getPhenotype();

            } else {
                final CustomEntityContext entityContext = entityRepository.getContext(attacked);
            }
        }
    }
}
