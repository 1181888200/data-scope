package com.lwl.data.scope.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class BaseModel implements Serializable {

    private Long id;
    private String createUser;
    private Date createTime;
    private String modifyUser;
    private Date modifyTime;


    /** 请求参数 */
    private transient Map<String, Object> params;

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }
}
