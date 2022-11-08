package com.wen.webmagic.demo5.entity;

import lombok.Data;
import sun.security.krb5.internal.PAData;

import java.util.Date;

/**
 * @author calwen
 * @since 2022/10/27
 */
@Data
public class MovieEntity {
    private Integer id;
    private String name;
    private String otherName;
    private String region;
    private String type;
    private Integer time;
    private String language;
    private String releaseYear;
    private Date releaseTime;
    private String actor;
    private String score;
    private String intro;
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;
}
