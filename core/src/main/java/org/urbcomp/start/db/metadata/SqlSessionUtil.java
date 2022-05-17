package org.urbcomp.start.db.metadata;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.urbcomp.start.db.constant.ConfigFileConstant;
import org.urbcomp.start.db.util.ResourceUtil;

import java.io.InputStream;

/**
 * This class is a tool class used to manage the SqlSession object of mybatis.
 * <p>
 * In order to reduce the overhead of frequent opening and closing of this object, we use the
 * singleton mode to maintain only one corresponding instance in memory.
 * <p>
 * In order to avoid the destruction of singleton pattern by serialization and deserialization,
 * we use static inner classes to maintain singleton objects.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
@Slf4j
public class SqlSessionUtil {

    /**
     * SqlSession instance
     */
    private final SqlSession sqlSession;

    /**
     * Nonparametric construction method
     * We use the method of reading the configuration file to construct the sqlsession singleton.
     * TODO: Maybe we should support reading configuration in other ways, such as Mysql, full pathname,
     * Zookeeper, Apollo configuration center, etc.
     */
    private SqlSessionUtil() {
        InputStream inputStream = ResourceUtil.readResource(ConfigFileConstant.MYBATIS_CONFIG_PATH);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = build.openSession(true);
    }

    /**
     * Private static internal classes to maintain singletons to avoid obtaining singletons through constructors.
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

    /**
     * get instance of SqlSession
     *
     * @return SqlSession
     */
    public static SqlSession getSession() {
        return SqlSessionUtilHolder.INSTANCE.sqlSession;
    }
}
