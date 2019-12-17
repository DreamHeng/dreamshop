package com.dreamshop.controller;

import com.dreamshop.pojo.bo.UserBO;
import com.dreamshop.service.UserService;
import com.dreamshop.util.DreamJSONResult;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author DreamHeng
 * @date 2019/12/12
 */
@Api(value = "注册登录", tags = "用于注册登录的接口")
@RestController
@RequestMapping("passport")
public class PassportController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @ApiImplicitParam(name="username",value="用户名",dataType="String", paramType = "path", required = true)
    @GetMapping("/checkUsernameIsExist")
    public DreamJSONResult checkUsernameIsExist(@RequestParam String username){
        //1.判断用户名是否为空
        if (StringUtils.isBlank(username)){
            return DreamJSONResult.errorMsg("用户名为空");
        }
        //2.用户已存在
        if(userService.checkUsernameIsExist(username)){
           return  DreamJSONResult.errorMsg("用户名已存在");
        }

        return  DreamJSONResult.ok();
    }

    @ApiOperation(value = "注册用户", notes = "用户注册功能", httpMethod = "POST")
    @PostMapping("/regist")
    public DreamJSONResult regist(@RequestBody UserBO userBO){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        //0.检查用户名、密码、确认密码不为空
        if(StringUtils.isBlank(username) ||
            StringUtils.isBlank(password) ||
            StringUtils.isBlank(confirmPassword)){
            return DreamJSONResult.errorMsg("用户名或密码不能为空");
        }
        //1.检查用户名已存在
        if(userService.checkUsernameIsExist(username)){
            return  DreamJSONResult.errorMsg("用户名已存在");
        }
        //2.检查两次密码一致
        if(!password.equals(confirmPassword)){
            return DreamJSONResult.errorMsg("两次密码不一致");
        }
        //3.检查密码长度小于6
        if (password.length() < 6){
            return DreamJSONResult.errorMsg("密码长度小于6");
        }

        userService.createUser(userBO);

        return DreamJSONResult.ok();
    }
}
