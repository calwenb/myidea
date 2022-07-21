package com.wen.foldertree;

import com.wen.foldertree.node.Node;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author Administrator
 * @create 2022/7/21 17:45
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Node> tpMap = new HashMap<>();
        //key 文件夹id，value 父文件夹id
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 1);
        map.put(4, 2);
        map.put(5, 1);
        Node head = new Node(-1);
        map.forEach((k, v) -> {

            System.out.println(k);
            System.out.println(v);

            Node node = new Node(k);
            Node childNode;

            if (tpMap.containsKey(v)) {
                childNode = tpMap.get(v);
            } else {
                childNode = new Node(v);
                tpMap.put(v, childNode);
            }
            node.getChildNode().add(childNode);
        });


    }
}
