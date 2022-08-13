package org.urbcomp.start.db.index;

public enum SpatialIndexType {
    Z2,
    XZ2,
    Z3,
    XZ3;

    public String getIndexName() {
        return this.name().toLowerCase();
    }
}
