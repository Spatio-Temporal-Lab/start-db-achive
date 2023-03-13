package org.urbcomp.cupid.db.flink;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.io.Serializable;

public class GeometrySerializer extends Serializer<Point> implements Serializable {

    @Override
    public Point read(Kryo kryo, Input input, Class aClass) {
        String wkt = input.readString();
        WKTReader reader = new WKTReader();
        try {
            return (Point) reader.read(wkt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void write(Kryo kryo, Output output, Point point) {
        output.writeString(point.toString());
    }
}
