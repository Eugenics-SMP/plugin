package lol.subhuman.eugenics.entity.damage;

public final class DamageContext {
    private final double damage;
    private final boolean trueDamage;
    private final DamageType damageType;

    public DamageContext(final double damage, final boolean trueDamage, final DamageType damageType) {
        this.damage = damage;
        this.trueDamage = trueDamage;
        this.damageType = damageType;
    }

    public final double getDamage() {
        return damage;
    }

    public boolean isTrueDamage() {
        return trueDamage;
    }

    public DamageType getDamageType() {
        return damageType;
    }
}
