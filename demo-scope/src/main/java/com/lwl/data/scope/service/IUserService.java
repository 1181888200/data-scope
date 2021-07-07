package com.lwl.data.scope.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lwl.data.scope.model.User;
import com.lwl.data.scope.mybatis.QueryRequest;

import java.util.List;

public interface IUserService extends IService<User> {


    List<User> listUser();

    List<User> listUserByParam(String name,String deptName);

    IPage<User> findPage(QueryRequest query);

}
