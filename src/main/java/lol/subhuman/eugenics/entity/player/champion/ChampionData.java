package lol.subhuman.eugenics.entity.player.champion;

import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeCategory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ChampionData {
    String name();

    PhenotypeCategory requiredPhenotype();
}
