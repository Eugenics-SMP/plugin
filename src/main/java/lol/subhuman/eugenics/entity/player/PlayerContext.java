package lol.subhuman.eugenics.entity.player;

import lol.subhuman.eugenics.database.Include;
import lol.subhuman.eugenics.entity.CustomEntityContext;
import lol.subhuman.eugenics.entity.player.champion.AbstractChampion;
import lol.subhuman.eugenics.entity.player.champion.ChampionContext;
import lol.subhuman.eugenics.entity.player.phenotype.PhenotypeContext;
import lol.subhuman.eugenics.entity.player.phenotype.impl.NoPhenotype;
import lol.subhuman.eugenics.property.ClampedProperty;
import lol.subhuman.eugenics.property.StandardProperty;
import lol.subhuman.eugenics.property.bindings.IClampedProperty;
import lol.subhuman.eugenics.property.bindings.IProperty;
import org.bukkit.entity.Player;

public final class PlayerContext extends CustomEntityContext {
    @Include
    private final IClampedProperty<Double> psl;

    @Include
    private final IClampedProperty<Double> pslStandardDeviation;

    @Include
    private final IProperty<PhenotypeContext<?>> phenotype;

    @Include
    private final IProperty<ChampionContext<?>> champion;

    public PlayerContext(final Player backingPlayer) {
        super(backingPlayer);

        this.psl = new ClampedProperty<>("psl", 4.0, 0.0, 8.0);
        this.pslStandardDeviation = new ClampedProperty<>("pslStandardDeviation", 1.0, 0.0, Double.MAX_VALUE);
        this.phenotype = new StandardProperty<>("phenotype", new PhenotypeContext<>(new NoPhenotype(this)));
        this.champion = new StandardProperty<>("champion", null);
    }

    public double getPsl() {
        return this.psl.getValue();
    }

    public void setPsl(final double value) {
        this.psl.setValue(value);
    }

    public double getPslStandardDeviation() {
        return this.pslStandardDeviation.getValue();
    }

    public void setPslStandardDeviation(final double value) {
        this.pslStandardDeviation.setValue(value);
    }

    public PhenotypeContext<?> getPhenotype() {
        return this.phenotype.getValue();
    }

    public void setPhenotype(final PhenotypeContext<?> value) {
        this.phenotype.setValue(value);
    }

    public ChampionContext<?> getChampion() {
        return this.champion.getValue();
    }

    public void setChampion(final ChampionContext<?> value) {
        this.champion.setValue(value);
    }
}
