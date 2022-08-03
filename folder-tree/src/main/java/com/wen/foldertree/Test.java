package com.wen.foldertree;

import com.wen.foldertree.node.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public void t1(HashMap<Integer, Integer> map) {
        HashMap<Integer, List<Integer>> tpMap = new HashMap<>();


        //HashMap<Integer, Integer> t = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public void t2(HashMap<Integer, Integer> map) {
        HashMap<Integer, List<Integer>> tpMap = new HashMap<>();

        map.forEach((k, v) -> {
            if (tpMap.containsKey(v)) {
                tpMap.get(v).add(k);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(k);
                tpMap.put(v, list);
            }
        });


        System.out.println(tpMap);

    }


}
