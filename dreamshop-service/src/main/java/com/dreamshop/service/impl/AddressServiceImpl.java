package com.dreamshop.service.impl;

import com.dreamshop.enums.BooleanEnum;
import com.dreamshop.mapper.UserAddressMapper;
import com.dreamshop.pojo.UserAddress;
import com.dreamshop.pojo.bo.AddressBO;
import com.dreamshop.service.AddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/1/20
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);

        return userAddressMapper.select(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {

        UserAddress userAddress = new UserAddress();

        //查询用户是否已有地址，如果没有，则新增为“默认地址”
        Integer isDefault = BooleanEnum.NO.type;
        userAddress.setUserId(addressBO.getUserId());
        int count = userAddressMapper.selectCount(userAddress);
        if(count == 0){
            isDefault = BooleanEnum.YES.type;
        }

        //生成唯一id
        String addressId = sid.nextShort();

        //保存数据到数据库
        userAddress.setId(addressId);
        userAddress.setCity(addressBO.getCity());
        userAddress.setDetail(addressBO.getDetail());
        userAddress.setDistrict(addressBO.getDistrict());
        userAddress.setMobile(addressBO.getMobile());
        userAddress.setProvince(addressBO.getProvince());
        userAddress.setReceiver(addressBO.getReceiver());
        userAddress.setIsDefault(isDefault);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());

        userAddressMapper.insert(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddress(AddressBO addressBO) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressBO.getAddressId());
        userAddress.setUserId(addressBO.getUserId());
        userAddress.setCity(addressBO.getCity());
        userAddress.setDetail(addressBO.getDetail());
        userAddress.setDistrict(addressBO.getDistrict());
        userAddress.setMobile(addressBO.getMobile());
        userAddress.setProvince(addressBO.getProvince());
        userAddress.setReceiver(addressBO.getReceiver());
        userAddress.setUpdatedTime(new Date());

        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserAddress(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressId);
        userAddress.setUserId(userId);

        userAddressMapper.delete(userAddress);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddressToBeDefault(String userId, String addressId) {
        //修改原默认地址
        UserAddress oldUserAddress = new UserAddress();
        oldUserAddress.setUserId(userId);
        oldUserAddress.setIsDefault(BooleanEnum.YES.type);
        List<UserAddress> select = userAddressMapper.select(oldUserAddress);
        for (UserAddress ua : select) {
            ua.setIsDefault(BooleanEnum.NO.type);
            userAddressMapper.updateByPrimaryKeySelective(ua);
        }

        //修改新的默认地址
        UserAddress newUserAddress = new UserAddress();
        newUserAddress.setUserId(userId);
        newUserAddress.setIsDefault(BooleanEnum.YES.type);
        newUserAddress.setId(addressId);
        userAddressMapper.updateByPrimaryKeySelective(newUserAddress);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserAddress queryUserAddres(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressId);
        userAddress.setUserId(userId);
        return userAddressMapper.selectOne(userAddress);
    }
}
