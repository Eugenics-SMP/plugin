package lol.subhuman.eugenics.entity.repository;

import lol.subhuman.eugenics.entity.CustomEntityContext;
import lol.subhuman.eugenics.entity.repository.bindings.IEntityContextRepository;
import org.bukkit.entity.LivingEntity;

import java.util.Map;

public final class CachedEntityContextRepository implements IEntityContextRepository {
    private final Map<LivingEntity, CustomEntityContext> contextCache;

    public CachedEntityContextRepository(final Map<LivingEntity, CustomEntityContext> contextCache) {
        this.contextCache = contextCache;
    }

    @Override
    public void cacheContext(final CustomEntityContext context) {
        contextCache.put(context.getBackingEntity(), context);
    }

    @Override
    public void removeContext(final LivingEntity entity) {
        contextCache.remove(entity);
    }

    @Override
    public CustomEntityContext getContext(final LivingEntity context) {
        return contextCache.getOrDefault(context, null);
    }
}
