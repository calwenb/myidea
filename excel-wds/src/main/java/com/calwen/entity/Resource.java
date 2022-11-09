package com.calwen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * File实体类
 *
 * @author calwen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    private String name;
    private String version;
    private Double use;
    private String id;
    private Double returnUse;
}
