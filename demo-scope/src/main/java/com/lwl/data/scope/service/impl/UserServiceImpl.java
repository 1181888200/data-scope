package com.lwl.data.scope.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lwl.data.scope.mapper.UserMapper;
import com.lwl.data.scope.model.User;
import com.lwl.data.scope.mybatis.QueryRequest;
import com.lwl.data.scope.mybatis.SortUtil;
import com.lwl.data.scope.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {


    @Override
    public List<User> listUser() {
        return this.baseMapper.listUser();
    }

    @Override
    public List<User> listUserByParam(String name, String deptName) {
        return this.baseMapper.listUserByParam(name,deptName);
    }

    @Override
    public IPage<User> findPage(QueryRequest pageRequest) {
        Page<User> page = new Page<>();
        page.setCurrent(pageRequest.getPageSize());
        page.setSize(pageRequest.getPageNum());
        SortUtil.handlePageSort(pageRequest, page, "u.create_time", SortUtil.ORDER_DESC, false);
        return page.setRecords(this.baseMapper.listUser(page));
    }
}
