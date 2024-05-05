package lol.subhuman.eugenics.entity.player.champion;

import lol.subhuman.eugenics.entity.player.PlayerContext;

public abstract class AbstractChampion {
    private final PlayerContext playerContext;

    public AbstractChampion(final PlayerContext playerContext) {
        this.playerContext = playerContext;
    }
}
