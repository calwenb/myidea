package com.wen.foldertree.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * node 数据结构
 *
 * @author calwen
 * @since 2022/7/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private Integer Id;
    private String name;
    private List<Node> childNode;
}

