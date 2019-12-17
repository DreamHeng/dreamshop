package com.dreamshop.service.impl;

import com.dreamshop.enums.SexEnum;
import com.dreamshop.mapper.UsersMapper;
import com.dreamshop.pojo.Users;
import com.dreamshop.pojo.bo.UserBO;
import com.dreamshop.service.UserService;
import com.dreamshop.util.DateUtil;
import com.dreamshop.util.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author DreamHeng
 * @date 2019/12/9
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean checkUsernameIsExist(String username) {
        Example usersExample = new Example(Users.class);
        Example.Criteria criteria = usersExample.createCriteria();
        criteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(usersExample);

        return !(result == null);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        //获取唯一用户id
        String userId = sid.nextShort();

        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            //用户密码使用MD5加密存储
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认用户昵称为用户名
        user.setNickname(userBO.getUsername());
        // 默认头像
        user.setFace(USER_FACE);
        // 默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认性别 保密
        user.setSex(SexEnum.SECTRE.tye);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);

        return user;
    }
}
