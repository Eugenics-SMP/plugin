package lol.subhuman.eugenics.entity.player.champion;

import lol.subhuman.eugenics.database.Include;
import lol.subhuman.eugenics.entity.damage.DamageContext;
import lol.subhuman.eugenics.entity.damage.DamageResult;
import lol.subhuman.eugenics.entity.damage.IDamageModifier;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.champion.ability.special.AbstractSpecialAbility;
import lol.subhuman.eugenics.property.ClampedProperty;
import lol.subhuman.eugenics.property.bindings.IClampedProperty;

public abstract class AbstractChampion implements IDamageModifier {
    protected final PlayerContext playerContext;
    protected final AbstractSpecialAbility specialAbility;

    @Include
    private final IClampedProperty<Integer> currentCharge;

    public AbstractChampion(final PlayerContext playerContext, final int maxCharge, final AbstractSpecialAbility specialAbility) {
        this.playerContext = playerContext;
        this.currentCharge = new ClampedProperty<>("currentCharge", 0, 0, maxCharge);
        this.specialAbility = specialAbility;
    }

    @Override
    public DamageResult modifyDamage(final DamageContext context, final double baseDamage) {
        return new DamageResult(baseDamage);
    }
}
