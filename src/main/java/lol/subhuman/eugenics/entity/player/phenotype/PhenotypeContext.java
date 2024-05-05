package lol.subhuman.eugenics.entity.player.phenotype;

import java.lang.annotation.Annotation;

public final class PhenotypeContext<T extends AbstractPhenotype> {
    private final T backingPhenotype;

    private final String name;
    private final PhenotypeCategory category;

    public PhenotypeContext(final T backingPhenotype) {
        this.backingPhenotype = backingPhenotype;

        final PhenotypeData annotation = backingPhenotype.getClass().getAnnotation(PhenotypeData.class);
        this.name = annotation.name();
        this.category = annotation.category();
    }

    public T getBackingPhenotype() {
        return backingPhenotype;
    }

    public String getName() {
        return name;
    }

    public PhenotypeCategory getCategory() {
        return category;
    }
}
