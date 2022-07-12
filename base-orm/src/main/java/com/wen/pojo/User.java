package com.wen.pojo;

import com.wen.annotation.FieldName;
import com.wen.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @FieldName("id")
    private Integer id;

    @FieldName("username")
    public String userName;

    @FieldName("password")
    private String passWord;

}
