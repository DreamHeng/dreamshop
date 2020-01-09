package com.dreamshop.pojo.vo;

/**
 * function:商品评价数量VO
 * @author DreamHeng
 * @date 2020/1/9
 */
public class CommentLevelCountsVO {
    //评价总数
    private Integer totalCounts;
    //好评数量
    private Integer goodCounts;
    //中评数量
    private Integer normalCounts;
    //差评数量
    private Integer badCounts;

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Integer getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(Integer goodCounts) {
        this.goodCounts = goodCounts;
    }

    public Integer getNormalCounts() {
        return normalCounts;
    }

    public void setNormalCounts(Integer normalCounts) {
        this.normalCounts = normalCounts;
    }

    public Integer getBadCounts() {
        return badCounts;
    }

    public void setBadCounts(Integer badCounts) {
        this.badCounts = badCounts;
    }
}
