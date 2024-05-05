package lol.subhuman.eugenics.entity.player.phenotype;

import lol.subhuman.eugenics.entity.player.PlayerContext;

public abstract class AbstractPhenotype {
    protected final PlayerContext backingPlayer;

    protected AbstractPhenotype(final PlayerContext backingPlayer) {
        this.backingPlayer = backingPlayer;
    }
}

