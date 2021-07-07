package com.lwl.data.scope;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwl.data.scope.model.User;
import com.lwl.data.scope.mybatis.QueryRequest;
import com.lwl.data.scope.service.IUserService;
import com.lwl.data.scope.utils.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class DataScopeTest {

    @Autowired
    private IUserService userService;


    @Test
    public void print() {
        userService.listUser().forEach(System.out::println);
    }

    @Test
    public void allUser() {
        LoginUser user = new LoginUser(userService.getById(1));
        // 此人权限为所有，则查询所有信息
        print();
    }

    @Test
    public void page() {
        LoginUser user = new LoginUser(userService.getById(6));
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setPageNum(0).setPageSize(3);
        IPage<User> page = userService.findPage(queryRequest);
        System.out.println(page.getTotal());
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void listUserByParam() {
        LoginUser user = new LoginUser(userService.getById(8));
        userService.listUserByParam("小",null).forEach(System.out::println);
    }

}
