package lol.subhuman.eugenics.entity.player.champion.impl;

import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.champion.AbstractChampion;
import lol.subhuman.eugenics.entity.player.champion.ChampionData;
import lol.subhuman.eugenics.entity.player.champion.ability.special.impl.StarvedSpecialAbility;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeCategory;

@ChampionData(name = "Mukasa Kakonge", requiredPhenotype = PhenotypeCategory.NEGROID)
public final class MukasaKakongeChampion extends AbstractChampion {
    public MukasaKakongeChampion(final PlayerContext playerContext) {
        super(playerContext, 100, new StarvedSpecialAbility(playerContext));
    }
}
