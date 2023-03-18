package org.urbcomp.cupid.db.algorithm.reachable;

import org.locationtech.jts.geom.Polygon;
import org.urbcomp.cupid.db.model.point.SpatialPoint;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;

public abstract class AbstractReachableArea {
    protected final SpatialPoint startPt;
    protected final double timeBudgetInS;
    protected final String travelMode;
    protected final RoadNetwork roadNetwork;

    public AbstractReachableArea(RoadNetwork roadNetwork, SpatialPoint startPt, double timeBudgetInS, String travelMode)
    {
        this.startPt = startPt;
        this.roadNetwork = roadNetwork;
        this.timeBudgetInS = timeBudgetInS;
        this.travelMode = travelMode;
    }

    public abstract Polygon getHull();

}
