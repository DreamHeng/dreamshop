package com.dreamshop.enums;

/**
 * function:商品评价等级 枚举类
 * @author DreamHeng
 * @date 2020/1/9
 */
public enum CommentLevelEnum {
    GOOD(1, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评");

    public final Integer type;
    public final String value;

    CommentLevelEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
