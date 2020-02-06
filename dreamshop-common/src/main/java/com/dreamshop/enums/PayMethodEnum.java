package com.dreamshop.enums;

/**
 * function: 支付方式枚举
 *
 * @author DreamHeng
 * @date 2020/2/3
 */
public enum PayMethodEnum {

    WEIXIN(1, "微信"),
    ALIPAY(2, "支付宝");

    public final Integer type;
    public final String value;

    PayMethodEnum(Integer type, String value){
        this.type = type;
        this.value = value;
    }
}
