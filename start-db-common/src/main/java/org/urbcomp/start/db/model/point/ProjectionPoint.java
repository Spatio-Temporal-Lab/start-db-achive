package org.urbcomp.start.db.model.point;

public class ProjectionPoint extends SpatialPoint {
    /**
     * 误差距离，单位为m
     */
    private final double errorDistanceInMeter;
    /**
     * 投影的斜率（具体含义参考GeoFunction类）
     */
    private final double rate;

    /**
     * 构造函数
     *
     * @param point 映射点
     * @param errorDistance 匹配误差
     * @param rate 斜率
     */
    public ProjectionPoint(SpatialPoint point, double errorDistance, double rate) {
        super(point.getLng(), point.getLat());
        this.errorDistanceInMeter = errorDistance;
        this.rate = rate;
    }

    public double getErrorDistanceInMeter() {
        return errorDistanceInMeter;
    }

    public double getRate() {
        return rate;
    }
}
