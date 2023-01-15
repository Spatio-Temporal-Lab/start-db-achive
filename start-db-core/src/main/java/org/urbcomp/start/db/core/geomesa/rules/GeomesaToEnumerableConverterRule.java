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

package org.urbcomp.start.db.core.geomesa.rules;

import org.apache.calcite.adapter.enumerable.EnumerableConvention;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.convert.ConverterRule;
import org.apache.calcite.rel.core.RelFactories;
import org.apache.calcite.tools.RelBuilderFactory;
import org.urbcomp.start.db.geomesa.GeomesaConstant;
import org.urbcomp.start.db.geomesa.GeomesaToEnumeratorConverter;

import java.util.function.Predicate;

/**
 * This Rule is used to convert Geomesa Logic to Linq4J Enumerable
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class GeomesaToEnumerableConverterRule extends ConverterRule {

    /**
     * ConverterRule Instance
     */
    public static final ConverterRule INSTANCE = new GeomesaToEnumerableConverterRule(
        RelFactories.LOGICAL_BUILDER
    );

    /**
     * Construct Function with only One Parameter
     *
     * @param relBuilderFactory RelNoade Factory
     */
    public GeomesaToEnumerableConverterRule(RelBuilderFactory relBuilderFactory) {
        super(
            RelNode.class,
            (Predicate<? super RelNode>) relNode -> true,
            GeomesaConstant.CONVENTION(),
            EnumerableConvention.INSTANCE,
            relBuilderFactory,
            "GeomesaToEnumerableConverterRule"
        );
    }

    /**
     * Convert RelNode to GeomesaToEnumeratorConverter
     *
     * @param rel RelNode
     * @return GeomesaToEnumeratorConverter
     */
    @Override
    public RelNode convert(RelNode rel) {
        RelTraitSet newTraitSet = rel.getTraitSet().replace(getOutConvention());
        return new GeomesaToEnumeratorConverter(rel.getCluster(), newTraitSet, rel);
    }
}
