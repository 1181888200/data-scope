package com.lwl.data.scope.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User extends BaseModel {


    private String name;

    private String password;

    private int age;

    private Long deptId;

    private String dataScope;

    private transient String deptName;

}
