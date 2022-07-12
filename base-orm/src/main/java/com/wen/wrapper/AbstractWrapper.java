package com.wen.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class AbstractWrapper {
    //WhereNode的内部类
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node {
        private String operating;
        private String field;
        private Object value;
    }

    private final ArrayList<Node> whereList;

    public AbstractWrapper() {
        whereList = new ArrayList<>();
    }


    public void add(String field, Object value) {
        Node node = new Node("HEAD", field, value);
        whereList.add(node);
    }

    public void and(String field, Object value) {
        Node node = new Node("AND", field, value);
        whereList.add(node);
    }

    public void or(String field, Object value) {
        Node node = new Node("OR", field, value);
        whereList.add(node);
    }

    public ArrayList<Node> getWhereList() {
        return whereList;
    }

    public HashMap<String, Object> getResult() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        ArrayList<Object> setList = new ArrayList<>();
        StringBuffer whereSQL = new StringBuffer();
        for (Node node : whereList) {
            String operating = node.getOperating();
            String field = node.getField();
            Object value = node.getValue();
            if (operating.equals("HEAD")) {
                whereSQL.append(field).append("= ? ");
            } else {
                whereSQL.append(operating).append(" ").append(field).append("= ? ");
            }
            setList.add(value);
        }
        map.put("sql", whereSQL);
        map.put("setSQL", setList);
        return map;
    }
}
