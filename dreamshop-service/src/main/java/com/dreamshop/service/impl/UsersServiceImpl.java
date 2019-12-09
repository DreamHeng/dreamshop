package com.dreamshop.service.impl;

import com.dreamshop.mapper.UsersMapper;
import com.dreamshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional()
    public List getAll() {
        return usersMapper.selectAll();
    }
}
