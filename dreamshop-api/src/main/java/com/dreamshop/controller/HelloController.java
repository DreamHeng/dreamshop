package com.dreamshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author DreamHeng
 * @date 2019/12/1
 */
@ApiIgnore //swagger2文档忽略该controller
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello(){
        return "Hello 恒";
    }
}
