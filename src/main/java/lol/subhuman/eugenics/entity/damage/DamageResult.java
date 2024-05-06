package lol.subhuman.eugenics.entity.damage;

public final class DamageResult {
    private double damage;
    private boolean cancelledHit;

    public DamageResult() {
        this(0);
    }

    public DamageResult(final double damage) {
        this.damage = damage;
        this.cancelledHit = false;
    }

    public double getDamage() {
        return damage;
    }

    public boolean isCancelledHit() {
        return cancelledHit;
    }

    public void cancel() {
        this.cancelledHit = true;
        this.damage = 0;
    }
}
