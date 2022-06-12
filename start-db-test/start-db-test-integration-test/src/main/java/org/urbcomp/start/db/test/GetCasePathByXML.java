/*
 * Copyright 2022 ST-Lab
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License version 2 as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

package org.urbcomp.start.db.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class GetCasePathByXML {

    private final static Logger log = LoggerFactory.getLogger(GetCasePathByXML.class);

    /**
     * 获取resources中cases目录下, 所有sql用例的xml文件路径
     *
     * @return 返回cases目录下, 所有sql用例的xml文件路径列表
     * */
    public static ArrayList<String> getSqlCaseXMLs() {
        String casePath = Objects.requireNonNull(
            GetCasePathByXML.class.getClassLoader().getResource("cases")
        ).getPath();
        String[] foldList = new File(casePath).list();
        ArrayList<String> caseFileList = new ArrayList<>();
        if (foldList != null) {
            for (String fold : foldList) {
                String foldPath = casePath + File.separator + fold;
                caseFileList.addAll(getFilesInFold(foldPath));
            }
        } else {
            log.info("文件内容为空");
        }
        return caseFileList;
    }

    /**
     * 传入文件夹名称, 返回文件夹下的文件路径列表, 不包括文件夹
     *
     * @return 返回文件列表
     * */
    private static ArrayList<String> getFilesInFold(String foldPath) {
        String[] fileList = new File(foldPath).list();
        ArrayList<String> fileArrayList = new ArrayList<>();
        if (fileList != null) {
            for (String fileName : fileList) {
                File file = new File(foldPath + File.separator + fileName);
                if (file.isFile() && !file.isDirectory()) {
                    fileArrayList.add(file.getPath());
                }
            }
        }
        return fileArrayList;
    }
}
