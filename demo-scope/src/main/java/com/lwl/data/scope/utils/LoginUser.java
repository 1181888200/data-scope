package com.lwl.data.scope.utils;

import com.lwl.data.scope.model.User;
import lombok.Data;

/**
 * @description： 模拟用户信息
 * @author     ：lwl
 * @date       ：2021/7/6 13:48
 * @version:     1.0.0
 */
@Data
public class LoginUser {

    private static User user;

    public LoginUser() {

    }

    public LoginUser(User user) {
        this.user = user;
    }

    public static User getCurrent(){
        return user;
    }

}
