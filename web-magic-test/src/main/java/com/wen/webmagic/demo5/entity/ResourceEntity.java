package com.wen.webmagic.demo5.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author calwen
 * @since 2022/10/27
 */
@Data
public class ResourceEntity {
    private Integer id;
    private String type;
    private Boolean valid;
    private String resourceLink;
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;
}
