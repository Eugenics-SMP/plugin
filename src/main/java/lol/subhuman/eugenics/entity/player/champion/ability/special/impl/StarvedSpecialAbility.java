package lol.subhuman.eugenics.entity.player.champion.ability.special.impl;

import lol.subhuman.eugenics.entity.player.PlayerContext;
import lol.subhuman.eugenics.entity.player.champion.ability.special.AbstractSpecialAbility;

public final class StarvedSpecialAbility extends AbstractSpecialAbility {
    public StarvedSpecialAbility(final PlayerContext playerContext) {
        super(playerContext, 100, "Starved", () -> "");
    }

    @Override
    public void use(final PlayerContext playerContext) {
        
    }
}
