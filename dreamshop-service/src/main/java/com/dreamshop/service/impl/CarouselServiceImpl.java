package com.dreamshop.service.impl;

import com.dreamshop.mapper.CarouselMapper;
import com.dreamshop.pojo.Carousel;
import com.dreamshop.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2020/1/1
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example carouselExample = new Example(Carousel.class);
        carouselExample.orderBy("sort");
        Example.Criteria criteria = carouselExample.createCriteria();
        criteria.andEqualTo("isShow",isShow);
        List<Carousel> carousels = carouselMapper.selectByExample(carouselExample);

        return carousels;
    }
}
