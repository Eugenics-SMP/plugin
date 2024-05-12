package lol.subhuman.eugenics.entity.player.champion.impl;

import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.champion.AbstractChampion;
import lol.subhuman.eugenics.entity.player.champion.ChampionData;
import lol.subhuman.eugenics.entity.player.champion.ability.special.impl.WrathSpecialAbility;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeCategory;

@ChampionData(name = "Fredrik Ljungberg", requiredPhenotype = PhenotypeCategory.NORDIC)
public final class FredrikLjungbergChampion extends AbstractChampion {
    public FredrikLjungbergChampion(final PlayerContext playerContext) {
        super(playerContext, 100, new WrathSpecialAbility(playerContext));
    }
}
