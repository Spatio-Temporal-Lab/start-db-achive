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

package org.urbcomp.start.db.metadata;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.urbcomp.start.db.constant.ConfigFileConstant;

import java.io.InputStream;

/**
 * This class is similar to SqlSession.
 * 
 * @author Wang Bohong
 * @date 2022-05-20 16:17:19
 */
@Slf4j
public class SqlSessionUtilManual {

    /**
     * SqlSession instance manual commit
     */
    private final SqlSession sqlSession;


    private SqlSessionUtilManual() {
        InputStream inputStream = this.getClass().getClassLoader()
                        .getResourceAsStream(ConfigFileConstant.MYBATIS_CONFIG_PATH);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = build.openSession();
    }

    /**
     * Private static internal classes to maintain singletons to avoid obtaining singletons through
     * constructors.
     */
    private static class SqlSessionUtilHolderManual {
        private static final SqlSessionUtilManual INSTANCE = new SqlSessionUtilManual();
    }

    /**
     * get instance of SqlSessionUtil
     * 
     * @return SqlSessionUtil
     */
    public static SqlSessionUtilManual getInstance() {
        return SqlSessionUtilHolderManual.INSTANCE;
    }

    /**
     * get instance of SqlSession (manual commit)
     * 
     * @return SqlSession
     */
    public static SqlSession getSession() {
        return SqlSessionUtilHolderManual.INSTANCE.sqlSession;
    }
}
