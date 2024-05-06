package lol.subhuman.eugenics.entity.player.phenotype.impl.negroid.bambutid;

import lol.subhuman.eugenics.entity.damage.DamageContext;
import lol.subhuman.eugenics.entity.damage.DamageResult;
import lol.subhuman.eugenics.entity.damage.DamageType;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.phenotype.AbstractPhenotype;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeCategory;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeData;

@PhenotypeData(name = "North Bantuid", category = PhenotypeCategory.NEGROID, requiredPsl = 0.0F)
public final class NorthBantuidPhenotype extends AbstractPhenotype {
    public static final double MELEE_DAMAGE_MULTIPLIER = 0.95F;

    public NorthBantuidPhenotype(final PlayerContext backingPlayer) {
        super(backingPlayer);
    }

    @Override
    public DamageResult modifyDamage(final DamageContext context, final double baseDamage) {
        if (context.getDamageType() == DamageType.MELEE) {
            final double reducedDamage = baseDamage * MELEE_DAMAGE_MULTIPLIER;
            return new DamageResult(reducedDamage);
        }
        return super.modifyDamage(context, baseDamage);
    }
}
