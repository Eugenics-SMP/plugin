package lol.subhuman.eugenics.entity.player.champion;

import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeCategory;

public final class ChampionContext<T extends AbstractChampion> {
    private final T backingChampion;

    private final String name;
    private final PhenotypeCategory requiredCategory;

    public ChampionContext(final T backingChampion) {
        this.backingChampion = backingChampion;

        final ChampionData data = backingChampion.getClass().getAnnotation(ChampionData.class);

        this.name = data.name();
        this.requiredCategory = data.requiredPhenotype();
    }

    public T getBackingChampion() {
        return backingChampion;
    }

    public String getName() {
        return name;
    }

    public PhenotypeCategory getRequiredCategory() {
        return requiredCategory;
    }
}
