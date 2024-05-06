package lol.subhuman.eugenics.entity.damage;

public interface IDamageModifier {
    DamageResult modifyDamage(DamageContext context, double baseDamage);
}
