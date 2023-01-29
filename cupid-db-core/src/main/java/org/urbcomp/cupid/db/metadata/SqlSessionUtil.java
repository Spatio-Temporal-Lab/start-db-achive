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

package org.urbcomp.cupid.db.metadata;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.urbcomp.cupid.db.util.ResourceUtil;

import java.io.InputStream;

/**
 * This class is a tool class used to manage the SqlSession object of mybatis.
 * <p>
 * In order to reduce the overhead of frequent opening and closing of this object, we use the
 * singleton mode to maintain only one corresponding instance in memory.
 * <p>
 * In order to avoid the destruction of singleton pattern by serialization and deserialization, we
 * use static inner classes to maintain singleton objects.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
@Slf4j
public class SqlSessionUtil {
    private static final String MYBATIS_CONFIG_PATH = "mybatis-config.xml";

    private final SqlSessionFactory sqlSessionFactory;

    /**
     * Nonparametric construction method We use the method of reading the configuration file to
     * construct the sqlsession singleton. TODO: Maybe we should support reading configuration in
     * other ways, such as Mysql, full pathname, Zookeeper, Apollo configuration center, etc.
     */
    private SqlSessionUtil() {
        InputStream inputStream = ResourceUtil.readResource(MYBATIS_CONFIG_PATH);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * Private static internal classes to maintain singletons to avoid obtaining singletons through
     * constructors.
     */
    private static class SqlSessionUtilHolder {
        private static final SqlSessionUtil INSTANCE = new SqlSessionUtil();
    }

    /**
     * get instance of SqlSessionUtil
     *
     * @return SqlSessionUtil
     */
    public static SqlSessionUtil getInstance() {
        return SqlSessionUtilHolder.INSTANCE;
    }

    public static SqlSession createSqlSession(boolean autoCommit) {
        return getInstance().sqlSessionFactory.openSession(autoCommit);
    }
}
