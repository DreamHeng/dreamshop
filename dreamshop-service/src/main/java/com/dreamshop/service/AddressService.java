package com.dreamshop.service;

import com.dreamshop.pojo.UserAddress;
import com.dreamshop.pojo.bo.AddressBO;

import java.util.List;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/1/20
 */
public interface AddressService {

    /**
     * function: 根据用户id查询用户的收货地址
     * @param userId
     * @return java.util.List<com.dreamshop.pojo.UserAddress>
     */
    List<UserAddress> queryAll(String userId);

    /**
     * function: 用户新增地址
     * @param addressBO
     * @return void
     */
    void addNewUserAddress(AddressBO addressBO);

    /**
     * function: 用户修改地址
     * @param addressBO
     * @return void
     */
    void updateUserAddress(AddressBO addressBO);

    /**
     * function: 根据用户id和地址id删除对应的用户地址信息
     * @param userId
     * @param addressId
     * @return void
     */
    void deleteUserAddress(String userId, String addressId);

    /**
     * function: 修改默认地址
     * @param userId
     * @param addressId
     * @return void
     */
    void updateUserAddressToBeDefault(String userId, String addressId);

    /**
     * function: 根据用户id和地址id获取用户地址信息
     * @param userId
     * @param addressId
     * @return com.dreamshop.pojo.UserAddress
     */
    UserAddress queryUserAddres(String userId, String addressId);
}
