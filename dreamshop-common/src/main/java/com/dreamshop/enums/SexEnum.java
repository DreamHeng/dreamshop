package com.dreamshop.enums;

/**
 * function: 性别枚举类
 * @author DreamHeng
 * @date 2019/12/17
 */
public enum SexEnum {
    //女
    WOMAN(0,"女"),
    //男
    MAN(1,"男"),
    //保密
    SECTRE(2,"保密");

    public final Integer tye;
    public final String value;

    SexEnum(Integer tye, String value) {
        this.tye = tye;
        this.value = value;
    }
}
