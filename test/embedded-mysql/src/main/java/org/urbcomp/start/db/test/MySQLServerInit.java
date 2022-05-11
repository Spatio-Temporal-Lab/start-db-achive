package org.urbcomp.start.db.test;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * need docker env
 *
 * @author jimo
 * @date 2022/5/11 7:31
 **/
public class MySQLServerInit {

    private final static DockerImageName MYSQL_57_IMAGE = DockerImageName.parse("mysql:5.7.34");

    public static void main(String[] args) {
        MySQLContainer<?> mysql = new MySQLContainer<>(MYSQL_57_IMAGE)
                .withUsername("start_db")
                .withPassword("start_db")
                .withInitScript("metadata/ddl.sql")
                .withDatabaseName("meta_data");

        mysql.start();
    }
}
