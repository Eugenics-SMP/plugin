package lol.subhuman.eugenics.entity;

import lol.subhuman.eugenics.database.Include;
import lol.subhuman.eugenics.entity.damage.DamageContext;
import lol.subhuman.eugenics.entity.damage.DamageResult;
import lol.subhuman.eugenics.property.StandardProperty;
import lol.subhuman.eugenics.property.bindings.IProperty;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;

public class CustomEntityContext {
    protected final LivingEntity backingEntity;

    // Despite Spigot having this already this needs to persist, need to save to disk
    @Include
    protected final IProperty<String> customDisplayName;

    @Include
    protected final IProperty<Double> currentHealth;

    @Include
    protected final IProperty<Double> maximumHealth;

    @Include
    protected final IProperty<Double> baseDamage;

    @Include
    protected final IProperty<Double> defense;

    public CustomEntityContext(final LivingEntity backingEntity) {
        this.backingEntity = backingEntity;

        this.backingEntity.setCustomNameVisible(true);
        this.customDisplayName = new StandardProperty<>("customDisplayName", backingEntity.getCustomName());

        this.currentHealth = new StandardProperty<>("currentHealth", backingEntity.getHealth());
        this.maximumHealth = new StandardProperty<>("maximumHealth", backingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());

        this.defense = new StandardProperty<>("defense", 0.0);

        this.baseDamage = new StandardProperty<>("baseDamage", 0.0);
    }

    public LivingEntity getBackingEntity() {
        return backingEntity;
    }

    public DamageResult onAttacked(final DamageContext context) {
        final double damage = context.getDamage();
        final boolean trueDamage = context.isTrueDamage();

        final double defense = this.defense.getValue();
        final double defensePercentage = defense / (defense + 100);

        switch (context.getDamageType()) {
            case MELEE -> {
                final double calculatedDamage = damage * (1 - defensePercentage);
                final DamageResult damageResult = new DamageResult(calculatedDamage);
                return damageResult;
            }
            case LIGHTNING -> {

            }
        }

        return null;
    }
}
