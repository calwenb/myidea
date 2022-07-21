/*
package com.wen.foldertree;

import com.wen.foldertree.node.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public void t1() {
        HashMap<Integer, Node> tpMap = new HashMap<>();
        //key 文件夹id，value 父文件夹id
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 1);
        map.put(4, 2);
        map.put(5, 1);

        HashMap<Integer, Integer> t = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }


}
*/
