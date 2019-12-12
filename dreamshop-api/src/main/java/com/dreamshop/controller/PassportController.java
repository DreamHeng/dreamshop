package com.dreamshop.controller;

import com.dreamshop.service.UsersService;
import com.dreamshop.util.DreamJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DreamHeng
 * @date 2019/12/12
 */
@RestController
@RequestMapping("passport")
public class PassportController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/checkUsernameIsExist")
    public DreamJSONResult checkUsernameIsExist(@RequestParam String username){
        //1.判断用户名是否为空
        if (StringUtils.isBlank(username)){
            return DreamJSONResult.errorMsg("用户名为空");
        }
        //2.用户已存在
        if(usersService.checkUsernameIsExist(username)){
           return  DreamJSONResult.errorMsg("用户名已存在");
        }

        return  DreamJSONResult.ok();
    }
}
