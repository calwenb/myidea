package com.wen.foldertree;

import com.alibaba.fastjson.JSONObject;
import com.wen.foldertree.node.Model;
import com.wen.foldertree.pojo.People;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {
    public static void main(String[] args) {
        List<People> peopleList = getList();
        Model parentModel = new Model();
        parentModel.setLabel("开始节点");
        parentModel.setValue("");
        parentModel.setChildren(new ArrayList<>());

        Map<String, People> map = new HashMap<>();

        Map<String, List<Model>> modelMap = new HashMap<>();
        modelMap.put("", new ArrayList<>());

        for (People people : peopleList) {
            map.put(people.getId(), people);
        }
        for (People people : peopleList) {
            Model model = new Model();
            if (map.get(people.getId()) != null) {
                model.setValue(people.getId());
                model.setLabel(people.getName());
                model.setChildren(new ArrayList<>());
            } else {
                System.out.println("2222");
                model.setValue("");
                model.setLabel("");
                model.setChildren(new ArrayList<>());
            }
            if (StringUtils.isEmpty(people.getPid()) || map.get(people.getPid()) == null) {
                parentModel.getChildren().add(model);
                modelMap.get("").add(model);
                continue;
            }
            if (modelMap.get(people.getPid()) == null) {
                List<Model> list = new ArrayList();
                list.add(model);
                if (!StringUtils.isEmpty(people.getPid())) {
                    modelMap.put(people.getPid(), list);
                }
            } else {
                modelMap.get(people.getPid()).add(model);
            }
        }
        //recursion(parentModel, modelMap);
        System.out.println(parentModel);
        System.out.println(modelMap);
        //测试
        //String s = JSONObject.toJSONString(parentModel);
        //System.out.println(s);
    }

    //递归，将数据转换成树状
    private static void recursion(Model model, Map<String, List<Model>> selectVoMap) {
        if (model.getChildren() == null || model.getChildren().size() == 0) {

        } else {
            for (Model selectVoFor : model.getChildren()) {
                model.setChildren(selectVoMap.get(model.getValue()));
                selectVoFor.setChildren(selectVoMap.get(selectVoFor.getValue()));
                recursion(selectVoFor, selectVoMap);
            }
        }
    }


    //造假数据，比较懒，所以直接用的数字代替
    public static List<People> getList() {
        List<People> list = new ArrayList();
        People people1 = getPeople("1", "11", null);
        People people2 = getPeople("2", "22", "1");
        People people3 = getPeople("3", "33", "1");
        People people4 = getPeople("4", "44", "2");
        People people5 = getPeople("5", "55", "4");
        People people6 = getPeople("6", "66", "3");
        People people7 = getPeople("7", "77", "6");
        list.add(people1);
        list.add(people2);
        list.add(people3);
        list.add(people4);
        list.add(people5);
        list.add(people6);
        list.add(people7);
        return list;
    }

    public static People getPeople(String id, String name, String pid) {
        People people = new People();
        people.setId(id);
        people.setName(name);
        people.setPid(pid);
        return people;
    }
}

