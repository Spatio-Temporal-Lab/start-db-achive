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
package org.urbcomp.cupid.db.algorithm.mapmatch.routerecover;

import org.urbcomp.cupid.db.algorithm.shortestpath.AbstractShortestPath;
import org.urbcomp.cupid.db.model.point.CandidatePoint;
import org.urbcomp.cupid.db.model.point.MapMatchedPoint;
import org.urbcomp.cupid.db.model.roadnetwork.Path;
import org.urbcomp.cupid.db.model.roadnetwork.RoadNetwork;
import org.urbcomp.cupid.db.model.roadnetwork.RoadSegment;
import org.urbcomp.cupid.db.model.trajectory.MapMatchedTrajectory;
import org.urbcomp.cupid.db.model.trajectory.PathOfTrajectory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShortestPathPathRecover {
    private final AbstractShortestPath pathAlgo;
    private final RoadNetwork roadNetwork;

    public ShortestPathPathRecover(RoadNetwork roadNetwork, AbstractShortestPath pathAlgo) {
        this.roadNetwork = roadNetwork;
        this.pathAlgo = pathAlgo;
    }

    /**
     * 返回一个List的原因是，可能两个匹配点之间没有最短路径
     * @param mmTraj 匹配后的轨迹
     * @return 补全后的轨迹
     */
    public List<PathOfTrajectory> recover(MapMatchedTrajectory mmTraj) {
        List<PathOfTrajectory> results = new ArrayList<>();

        List<MapMatchedPoint> mmPoints = mmTraj.getMmPtList()
            .stream()
            .filter(o -> o.getCandidatePoint() != null)
            .collect(Collectors.toList());
        PathOfTrajectory pt = new PathOfTrajectory(mmTraj.getTid(), mmTraj.getTid());
        for (int i = 0; i < mmPoints.size() - 1; i++) {
            CandidatePoint pre = mmPoints.get(i).getCandidatePoint();
            CandidatePoint next = mmPoints.get(i + 1).getCandidatePoint();
            RoadSegment preRS = this.roadNetwork.getRoadSegmentById(pre.getRoadSegmentId());
            RoadSegment nextRS = this.roadNetwork.getRoadSegmentById(next.getRoadSegmentId());
            // 在同一个路段
            if (pre.getRoadSegmentId() == next.getRoadSegmentId()) {
                pt.addRoadSegmentIdIfNotEqual(pre.getRoadSegmentId());
                pt.addPointIfNotEqual(pre);
                for (int j = pre.getMatchedIndex() + 1; j <= next.getMatchedIndex(); j++) {
                    pt.addPointIfNotEqual(preRS.getPoints().get(j));
                }
                pt.addPointIfNotEqual(next);
            } else {
                // 添加前一个点到结束点的信息
                pt.addRoadSegmentIdIfNotEqual(pre.getRoadSegmentId());
                pt.addPointIfNotEqual(pre);
                for (int j = pre.getMatchedIndex() + 1; j < preRS.getPoints().size(); j++) {
                    pt.addPointIfNotEqual(preRS.getPoints().get(j));
                }
                Path path = pathAlgo.findShortestPath(preRS.getEndNode(), nextRS.getStartNode());
                if (path.getLengthInMeter() == Double.MAX_VALUE) {
                    // 未找到最短路径，结果切分
                    results.add(pt);
                    pt = new PathOfTrajectory(mmTraj.getTid(), mmTraj.getOid());
                } else {
                    path.getPoints().forEach(pt::addPointIfNotEqual);
                    path.getRoadSegmentIds().forEach(pt::addRoadSegmentIdIfNotEqual);
                    // 添加next所在路段的开始点到匹配点的信息
                    for (int j = 0; j <= next.getMatchedIndex(); j++) {
                        pt.addPointIfNotEqual(nextRS.getPoints().get(j));
                    }
                    pt.addPointIfNotEqual(next);
                    pt.addRoadSegmentIdIfNotEqual(next.getRoadSegmentId());
                }
            }
        }
        // 处理最后一个点的情况，有两种情况会执行这：1、只有一个匹配点；2、最后一个点与前一个点没有最短路径
        if (mmPoints.size() > 0) {
            CandidatePoint last = mmPoints.get(mmPoints.size() - 1).getCandidatePoint();
            pt.addPointIfNotEqual(last);
            pt.addRoadSegmentIdIfNotEqual(last.getRoadSegmentId());
            results.add(pt);
        }

        return results;
    }
}
