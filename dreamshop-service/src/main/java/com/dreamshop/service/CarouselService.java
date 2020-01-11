package com.dreamshop.service;

import com.dreamshop.pojo.Carousel;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2020/1/1
 */
public interface CarouselService {


    /**
     * function:获取所有轮播图
     * @param isShow
     * @return java.util.List<com.dreamshop.pojo.Carousel>
     */
    List<Carousel> queryAll(Integer isShow);

}
