/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 3 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.cupid.db.util;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

public class WKTUtils {
    private static final ThreadLocal<WKTReader> readerPool = ThreadLocal.withInitial(
        WKTReader::new
    );
    private static final ThreadLocal<WKTWriter> writerPool = ThreadLocal.withInitial(
        WKTWriter::new
    );

    public static Geometry read(String s) throws ParseException {
        return readerPool.get().read(s);
    }

    public static String write(Geometry g) {
        return writerPool.get().write(g);
    }
}
