package com.wen.foldertree.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Folder {
    private Integer id;
    private String name;
    private Integer fId;

}
