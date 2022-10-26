package com.wen.foldertree.node;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Data
@Getter
@Setter
public class Model {
    private String value;
    private String label;
    private List<Model> children;
}
