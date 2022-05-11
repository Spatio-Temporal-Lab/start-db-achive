package org.urbancomp.start.db;

import org.junit.BeforeClass;
import org.junit.Test;
import org.urbcomp.start.db.metadata.AccessorFactory;
import org.urbcomp.start.db.metadata.accessor.UserAccessor;
import org.urbcomp.start.db.util.ResourceUtil;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class UserAccessorTest {

    @BeforeClass
    public static void init() throws Exception {
        final Properties p = new Properties();
        try (final InputStream in = ResourceUtil.readResource("config.properties")) {
            p.load(in);
        }

        final String sqlTxt = Files.readAllLines(Paths.get("src/main/resources/metadata/ddl.sql"))
                .stream().filter(line -> !line.trim().startsWith("#") && !line.trim().startsWith("--")).collect(Collectors.joining());
        final String[] sqlList = sqlTxt.split(";");
        try (Connection conn = DriverManager.getConnection(p.getProperty("meta.jdbc.url"))) {
            for (String sql : sqlList) {
                final Statement stat = conn.createStatement();
                stat.execute(sql.trim());
            }
        }
    }

    @Test
    public void userTest() {
        try (UserAccessor userAccessor = AccessorFactory.getUserAccessor()) {
            userAccessor.selectAll();
            assertTrue(true);
        }
    }
}
