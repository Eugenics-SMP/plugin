package lol.subhuman.eugenics.entity.player.phenotype;

import lol.subhuman.eugenics.entity.damage.DamageContext;
import lol.subhuman.eugenics.entity.damage.DamageResult;
import lol.subhuman.eugenics.entity.damage.IDamageModifier;
import lol.subhuman.eugenics.entity.player.PlayerContext;

public abstract class AbstractPhenotype implements IDamageModifier {
    protected final PlayerContext backingPlayer;

    protected AbstractPhenotype(final PlayerContext backingPlayer) {
        this.backingPlayer = backingPlayer;
    }

    @Override
    public DamageResult modifyDamage(final DamageContext context, final double baseDamage) {
        return new DamageResult(baseDamage);
    }
}

