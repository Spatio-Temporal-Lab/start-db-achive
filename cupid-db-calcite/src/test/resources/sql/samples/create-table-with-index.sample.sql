CREATE TABLE gemo (
    name String,
    st Point,
    et Point,
    dtg Datetime,
    SPATIAL INDEX (st, dtg),
    SPATIAL INDEX (et, dtg),
    ATTRIBUTE INDEX(name, dtg)
)