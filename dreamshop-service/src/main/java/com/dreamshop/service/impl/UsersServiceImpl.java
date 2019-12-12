package com.dreamshop.service.impl;

import com.dreamshop.mapper.UsersMapper;
import com.dreamshop.pojo.Users;
import com.dreamshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2019/12/9
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean checkUsernameIsExist(String username) {
        Example usersExample = new Example(Users.class);
        Example.Criteria criteria = usersExample.createCriteria();
        criteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(usersExample);

        return !(result == null);
    }
}
