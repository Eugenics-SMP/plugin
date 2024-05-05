package lol.subhuman.eugenics.entity;

import lol.subhuman.eugenics.database.Include;
import lol.subhuman.eugenics.property.StandardProperty;
import lol.subhuman.eugenics.property.bindings.IProperty;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;

public class CustomEntityContext {
    private final LivingEntity backingEntity;

    // Despite Spigot having this already this needs to persist, need to save to disk
    @Include
    private final IProperty<String> customDisplayName;

    @Include
    private final IProperty<Double> currentHealth;

    @Include
    private final IProperty<Double> maximumHealth;

    @Include
    private final IProperty<Double> baseDamage;

    public CustomEntityContext(final LivingEntity backingEntity) {
        this.backingEntity = backingEntity;

        this.backingEntity.setCustomNameVisible(true);
        this.customDisplayName = new StandardProperty<>("customDisplayName", backingEntity.getCustomName());

        this.currentHealth = new StandardProperty<>("currentHealth", backingEntity.getHealth());
        this.maximumHealth = new StandardProperty<>("maximumHealth", backingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

        this.baseDamage = new StandardProperty<>("baseDamage", 0.0);
    }

    public LivingEntity getBackingEntity() {
        return backingEntity;
    }
}
