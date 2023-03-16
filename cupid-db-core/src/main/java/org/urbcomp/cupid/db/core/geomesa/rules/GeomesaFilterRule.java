/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.core.geomesa.rules;

import org.apache.calcite.plan.Convention;
import org.apache.calcite.plan.RelOptRuleCall;
import org.apache.calcite.plan.RelRule;
import org.apache.calcite.plan.RelTraitSet;
import org.apache.calcite.rel.logical.LogicalFilter;
import org.urbcomp.cupid.db.geomesa.GeomesaConstant;
import org.urbcomp.cupid.db.geomesa.rel.GeomesaFilter;
import org.urbcomp.cupid.db.geomesa.rel.GeomesaTableScan;

/**
 * This class is used to match the specified filter rules, convert the original query criteria into
 * the filter object of geotools, and push down.
 *
 * @author zaiyuan
 * @date 2022-05-01 15:17:07
 */
public class GeomesaFilterRule extends RelRule<GeomesaFilterRule.Config> {

    /**
     * Construct Function with One Parameter which is extended from super class.
     */
    protected GeomesaFilterRule(Config config) {
        super(config);
    }

    /**
     * Configuration of Filter Push Down Rule.
     */
    public interface Config extends RelRule.Config {
        Config DEFAULT = EMPTY.withOperandSupplier(
            b0 -> b0.operand(LogicalFilter.class)
                .oneInput(b1 -> b1.operand(GeomesaTableScan.class).noInputs())
        ).as(Config.class);

        /**
         * Creates a rule that uses this configuration.
         *
         * @return GeomesaFilterRule Instance
         */
        @Override
        default GeomesaFilterRule toRule() {
            return new GeomesaFilterRule(this);
        }
    }

    /**
     * <p>
     * Typically a rule would check that the nodes are registered and convert calcite RexNode to
     * Filter, creates a new expression.
     * </p>
     *
     * @param call Rule call
     * @see #matches(RelOptRuleCall)
     */
    @Override
    public void onMatch(RelOptRuleCall call) {
        LogicalFilter filter = call.rel(0);
        if (filter.getTraitSet().contains(Convention.NONE)) {
            RelTraitSet traits = filter.getTraitSet().replace(GeomesaConstant.CONVENTION());
            call.transformTo(
                new GeomesaFilter(
                    filter.getCluster(),
                    traits,
                    convert(filter.getInput(), GeomesaConstant.CONVENTION()),
                    filter.getRowType(),
                    filter.getCondition()
                )
            );
        }
    }
}
