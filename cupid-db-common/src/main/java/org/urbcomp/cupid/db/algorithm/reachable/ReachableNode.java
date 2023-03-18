package org.urbcomp.cupid.db.algorithm.reachable;

import org.urbcomp.cupid.db.model.roadnetwork.RoadNode;

public class ReachableNode {

    private final RoadNode node;
    private final double timeCost;

    public ReachableNode(RoadNode node, double timeCost)
    {
        this.node = node;
        this.timeCost = timeCost;
    }

    public RoadNode getNode()
    {
        return this.node;
    }

    public double getCost()
    {
        return this.timeCost;
    }

}