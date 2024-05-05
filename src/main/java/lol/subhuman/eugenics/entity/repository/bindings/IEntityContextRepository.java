package lol.subhuman.eugenics.entity.repository.bindings;

import lol.subhuman.eugenics.entity.CustomEntityContext;
import org.bukkit.entity.LivingEntity;

public interface IEntityContextRepository {
    void cacheContext(final CustomEntityContext context);

    void removeContext(final LivingEntity entity);

    CustomEntityContext getContext(final LivingEntity context);
}
