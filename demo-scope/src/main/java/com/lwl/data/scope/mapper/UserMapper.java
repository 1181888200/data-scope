package com.lwl.data.scope.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwl.data.scope.annotation.DataScope;
import com.lwl.data.scope.handler.UserDataScopeHandler;
import com.lwl.data.scope.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @DataScope(handlerClass = UserDataScopeHandler.class, tableName = "u")
    public List<User> listUser();

    public List<User> listUser(Page<?> page);

    @DataScope(handlerClass = UserDataScopeHandler.class, tableName = "u")
    List<User> listUserByParam(@Param(value = "name") String name, @Param(value = "deptName") String deptName);

}
