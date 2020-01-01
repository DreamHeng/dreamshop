package com.dreamshop.enums;

/**
 * function: 是否枚举类
 * @author DreamHeng
 * @date 2020/01/01
 */
public enum BooleanEnum {
    //否
    NO(0,"否"),
    //是
    YES(1,"是");

    public final Integer tye;
    public final String value;

    BooleanEnum(Integer tye, String value) {
        this.tye = tye;
        this.value = value;
    }
}
