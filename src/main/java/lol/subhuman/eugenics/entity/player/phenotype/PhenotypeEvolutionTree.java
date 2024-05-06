package lol.subhuman.eugenics.entity.player.phenotype;

import lol.subhuman.eugenics.entity.player.phenotype.impl.negroid.bambutid.MalagasidPhenotype;
import lol.subhuman.eugenics.entity.player.phenotype.impl.negroid.bambutid.NorthBantuidPhenotype;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PhenotypeEvolutionTree {
    private final Map<Class<? extends AbstractPhenotype>, Node> map;

    public PhenotypeEvolutionTree(final Map<Class<? extends AbstractPhenotype>, Node> map) {
        this.map = map;

        this.addNode(NorthBantuidPhenotype.class);

        this.addNode(MalagasidPhenotype.class);
    }

    public static final class Node {
        private final Class<? extends AbstractPhenotype> phenotype;
        private final List<Node> children;

        public Node(final Class<? extends AbstractPhenotype> phenotype) {
            this.phenotype = phenotype;
            this.children = new ArrayList<>();
        }

        public void addChild(final Node child) {
            children.add(child);
        }

        public Class<? extends AbstractPhenotype> getPhenotype() {
            return phenotype;
        }

        public List<Node> getChildren() {
            return children;
        }
    }

    private void addNode(final Class<? extends AbstractPhenotype> phenotype) {
        map.putIfAbsent(phenotype, new Node(phenotype));
    }

    public void addEvolution(final Class<? extends AbstractPhenotype> from, final Class<? extends AbstractPhenotype> to) {
        final Node parentNode = map.get(from);
        final Node childNode = map.get(to);

        if (parentNode == null || childNode == null) {
            return;
        }

        parentNode.children.add(childNode);
    }
}
