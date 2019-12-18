package com.dreamshop.service;

import com.dreamshop.pojo.Users;
import com.dreamshop.pojo.bo.UserBO;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2019/12/9
 */
public interface UserService {

    /**
     * function: 判断用户名是否存在
     * @param username
     * @return
     */
    boolean checkUsernameIsExist(String username);

    /**
     * function: 注册用户
     * @param userBO
     * @return
     */
    Users createUser(UserBO userBO);

    /**
     * function: 检查用户名密码，用来登录
     * @param username
     * @param password
     * @return
     */
    Users checkUsernameForLogin(String username,String password);
}
