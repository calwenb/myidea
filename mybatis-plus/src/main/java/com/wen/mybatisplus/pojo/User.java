package com.wen.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
//表名
@TableName("user")
public class User {
    //标记主键 ,自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    //映射字段，可以省略
    @TableField("username")
    private String username;

    private String password;

    private Integer age;


}
