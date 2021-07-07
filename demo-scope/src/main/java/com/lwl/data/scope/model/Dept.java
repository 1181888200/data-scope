package com.lwl.data.scope.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_dept")
public class Dept extends BaseModel {


    private String name;

    private String desc;

    private Long parentId;

}
