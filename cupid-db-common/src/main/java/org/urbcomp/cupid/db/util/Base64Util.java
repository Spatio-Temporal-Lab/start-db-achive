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

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author jimo
 **/
public class Base64Util {

    public static String encode(String s) {
        final BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String s) {
        final BASE64Decoder decoder = new BASE64Decoder();
        try {
            return new String(decoder.decodeBuffer(s), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
