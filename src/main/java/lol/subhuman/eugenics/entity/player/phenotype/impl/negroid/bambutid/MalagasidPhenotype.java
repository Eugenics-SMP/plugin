package lol.subhuman.eugenics.entity.player.phenotype.impl.negroid.bambutid;

import lol.subhuman.eugenics.entity.damage.DamageContext;
import lol.subhuman.eugenics.entity.damage.DamageResult;
import lol.subhuman.eugenics.entity.damage.DamageType;
import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.phenotype.AbstractPhenotype;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeCategory;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeData;

@PhenotypeData(name = "Malagasid", category = PhenotypeCategory.NEGROID, requiredPsl = 0.0F)
public final class MalagasidPhenotype extends AbstractPhenotype {
    public MalagasidPhenotype(final PlayerContext backingPlayer) {
        super(backingPlayer);
    }

    @Override
    public DamageResult modifyDamage(final DamageContext context, final double baseDamage) {
        final DamageType damageType = context.getDamageType();

        if (damageType == DamageType.LIGHTNING) {
            if (context.isTrueDamage()) {
                final DamageResult damageResult = new DamageResult(baseDamage);
                damageResult.cancel();

                return damageResult;
            }
        }

        return super.modifyDamage(context, baseDamage);
    }
}
