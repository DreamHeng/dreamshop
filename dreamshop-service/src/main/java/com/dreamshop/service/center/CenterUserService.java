package com.dreamshop.service.center;

import com.dreamshop.pojo.Users;
import com.dreamshop.pojo.bo.center.CenterUserBO;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/2/15
 */
public interface CenterUserService {

    /**
     * function: 根据用户id查询用户信息
     * @param userId
     * @return com.dreamshop.pojo.Users
     */
    Users queryUserInfo(String userId);

    /**
     * function: 更新用户信息
     * @param userId
     * @param centerUserBO
     * @return com.dreamshop.pojo.Users
     */
    Users updateUserInfo(String userId, CenterUserBO centerUserBO);
}
