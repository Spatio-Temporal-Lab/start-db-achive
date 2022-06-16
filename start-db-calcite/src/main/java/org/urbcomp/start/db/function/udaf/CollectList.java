package org.urbcomp.start.db.function.udaf;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zaiyuan
 * @date 2022-06-16 20:35:30
 */
public class CollectList {

    public List<Object> init() {
        return new ArrayList<>();
    }

    public List<Object> add(List<Object> accumulator, Object val) {
        accumulator.add(val);
        return accumulator;
    }

    public List<Object> merge(List<Object> accumulator1, List<Object> accumulator2) {
        accumulator1.addAll(accumulator2);
        return accumulator1;
    }

    public List<Object> result(List<Object> accumulator) {
        return accumulator;
    }
}