package com.wen.foldertree.node;

import java.util.ArrayList;
import java.util.List;

/**
 * node 数据结构
 *
 * @author calwen
 * @since 2022/7/21
 */
public class Node {
    private Integer Id;
    private List<Node> childNode;

    public Node() {
    }

    public Node(Integer Id) {
        this.Id = Id;
        this.childNode = new ArrayList<>();
    }

    public Node(Integer id, List<Node> childNode) {
        Id = id;
        this.childNode = childNode;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<Node> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<Node> childNode) {
        this.childNode = childNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "Id=" + Id +
                ", childNode=" + childNode +
                '}';
    }
}
