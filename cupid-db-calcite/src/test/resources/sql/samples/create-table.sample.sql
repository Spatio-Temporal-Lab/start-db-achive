CREATE TABLE start_default_table (
    idx Integer,
    ride_id String,
    started_at Timestamp,
    ended_at Timestamp,
    start_station_name String,
    start_station_id Double,
    start_point Point,
    end_station_name String,
    end_station_id Double,
    end_point Point,
    track LineString,
    member_casual String
);
