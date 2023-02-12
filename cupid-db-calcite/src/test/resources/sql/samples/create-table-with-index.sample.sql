CREATE TABLE gemo (
    name String,
    st Point,
    et Point,
    dtg Datetime,
    SPATIAL INDEX (st, dtg),
    SPATIAL INDEX spatial_index(et, dtg),
    ATTRIBUTE INDEX attribute_index(name, dtg)
)