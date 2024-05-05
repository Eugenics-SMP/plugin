package lol.subhuman.eugenics.entity.player.phenotype.impl;

import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.phenotype.AbstractPhenotype;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeCategory;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeData;

@PhenotypeData(name = "None", category = PhenotypeCategory.NONE, requiredPsl = 0)
public final class NoPhenotype extends AbstractPhenotype {
    public NoPhenotype(final PlayerContext backingPlayer) {
        super(backingPlayer);
    }
}
