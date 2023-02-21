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

package org.urbcomp.cupid.db.algorithm.mapmatch.tihmm.inner;

/**
 * 辅助class，计算emission， transition P
 */
public class HmmProbabilities {
    /**
     * emission p的log正太分布参数
     */
    private final double sigma;
    /**
     * transition p的指数分布参数
     */
    private final double beta;

    /**
     * 构造函数
     * @param sigma emission p的log正太分布参数
     * @param beta transition p的指数分布参数
     */
    public HmmProbabilities(double sigma, double beta) {
        this.sigma = sigma;
        this.beta = beta;
    }

    /**
     * Returns the logarithmic emission probability density.
     *
     * @param distance Absolute distance [m] between GPS measurement and map matching candidate.
     * @return 概率p
     */
    public double emissionLogProbability(double distance) {
        return logNormalDistribution(this.sigma, distance);
    }

    /**
     * @param routeLength    Length of the shortest route [m] between two consecutive map matching candidates
     * @param linearDistance Linear distance [m] between two consecutive GPS measurements
     * @return 概率p
     */
    public double transitionLogProbability(double routeLength, double linearDistance) {
        double transitionMetric = Math.abs(linearDistance - routeLength);
        if (transitionMetric > 500) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return logExponentialDistribution(this.beta, transitionMetric);
        }

    }

    /**
     * 数学方程，正太分布
     * @param sigma 正太分布参数
     * @param x 距离
     * @return 概率 p
     */
    private static double logNormalDistribution(double sigma, double x) {
        return Math.log(1.0 / (Math.sqrt(2.0 * Math.PI) * sigma)) + (-0.5 * Math.pow(x / sigma, 2));
    }


    /**
     * 数学方程， 指数分布
     * @param beta 指数分布参数
     * @param x 距离
     * @return 概率p
     */
    private static double logExponentialDistribution(double beta, double x) {
        return Math.log(1.0 / beta) - (x / beta);
    }


}
