package org.urbcomp.start.db.stream.catalog;

import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.table.catalog.Catalog;
import org.apache.flink.table.factories.CatalogFactory;
import org.apache.flink.table.factories.FactoryUtil;

import java.util.HashSet;
import java.util.Set;

import static org.apache.flink.table.factories.FactoryUtil.PROPERTY_VERSION;
import static org.urbcomp.start.db.stream.catalog.StartCatalogFactoryOptions.*;

/**
 * custom flink catalog
 *
 * @author jimo
 **/
public class StartCatalogFactory implements CatalogFactory {

    @Override
    public String factoryIdentifier() {
        return null;
    }

    @Override
    public Set<ConfigOption<?>> requiredOptions() {
        final Set<ConfigOption<?>> options = new HashSet<>();
        options.add(DEFAULT_DATABASE);
        options.add(USERNAME);
        options.add(PASSWORD);
        options.add(BASE_URL);
        return options;
    }

    @Override
    public Set<ConfigOption<?>> optionalOptions() {
        final Set<ConfigOption<?>> options = new HashSet<>();
        options.add(PROPERTY_VERSION);
        return options;
    }

    @Override
    public Catalog createCatalog(Context context) {
        final FactoryUtil.CatalogFactoryHelper helper =
                FactoryUtil.createCatalogFactoryHelper(this, context);
        helper.validate();

//        return new JdbcCatalog(
//                context.getName(),
//                helper.getOptions().get(DEFAULT_DATABASE),
//                helper.getOptions().get(USERNAME),
//                helper.getOptions().get(PASSWORD),
//                helper.getOptions().get(BASE_URL));
        return null;
    }
}
