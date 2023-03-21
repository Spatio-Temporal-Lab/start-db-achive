/*
 * This file is inherited from Apache Calcite and modifed by ST-Lab under apache license.
 * You can find the original code from
 *
 * https://github.com/apache/calcite
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.urbcomp.cupid.db.function;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zaiyuan, XiangHe
 * @date 2022-05-26 23:12:07
 */
public class StringFunction {
    @CupidDBFunction("concat")
    public String concat(String str1, String str2) {
        return str1.concat(str2);
    }

    @CupidDBFunction("reverse")
    public String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    @CupidDBFunction("trim")
    public String trim(String str) {
        return str.trim();
    }

    @CupidDBFunction("ltrim")
    public String ltrim(String str) {
        int i = 0;
        int n = str.length();
        while (i < n && str.charAt(i) == ' ')
            ++i;
        return str.substring(i);
    }

    @CupidDBFunction("rtrim")
    public String rtrim(String str) {
        int i = str.length() - 1;
        while (i >= 0 && str.charAt(i) == ' ')
            --i;
        return str.substring(0, i + 1);
    }

    @CupidDBFunction("lpad")
    public String lpad(String str, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(' ');
        }
        return sb + str;
    }

    @CupidDBFunction("lpad")
    public String lpad(String str, int len, String pad) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(pad);
        }
        return sb + str;
    }

    @CupidDBFunction("rpad")
    public String rpad(String str, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(' ');
        }
        return str + sb;
    }

    @CupidDBFunction("rpad")
    public String rpad(String str, int len, String pad) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(pad);
        }
        return str + sb;
    }

    @CupidDBFunction("length")
    public int length(String str) {
        int n = str.length();
        int length = n;
        for (int i = 0; i < n; ++i) {
            int ascii = Character.codePointAt(str, i);
            if (ascii > 256) ++length;
        }
        return length;
    }

    @CupidDBFunction("charLength")
    public int charLength(String str) {
        return str.length();
    }

    @CupidDBFunction("locate")
    public int locate(String substr, String str) {
        return str.indexOf(substr) + 1;
    }

    @CupidDBFunction("locate")
    public int locate(String substr, String str, int pos) {
        return str.indexOf(substr, pos) + 1;
    }

    @CupidDBFunction("md5")
    public String md5(String str) throws NoSuchAlgorithmException {
        final char[] hexDigits = {
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'A',
            'B',
            'C',
            'D',
            'E',
            'F' };
        byte[] btInput = str.getBytes();
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        mdInst.update(btInput);
        byte[] md = mdInst.digest();
        int j = md.length;
        char[] code = new char[j * 2];
        int k = 0;
        for (byte byte0 : md) {
            code[k++] = hexDigits[byte0 >>> 4 & 0xf];
            code[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(code);
    }
}
