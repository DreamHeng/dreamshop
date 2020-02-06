package com.dreamshop.controller;

import com.dreamshop.enums.BooleanEnum;
import com.dreamshop.pojo.Carousel;
import com.dreamshop.pojo.Category;
import com.dreamshop.pojo.vo.CategoryVO;
import com.dreamshop.pojo.vo.NewItemsVO;
import com.dreamshop.service.CarouselService;
import com.dreamshop.service.CategoryService;
import com.dreamshop.util.DreamJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * function:首页Controller
 * @author DreamHeng
 * @date 2020/1/1
 */

@Api(value = "首页",tags = "首页展示相关接口")
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public DreamJSONResult carousel(){
        List<Carousel> carousels = carouselService.queryAll(BooleanEnum.YES.type);
        return DreamJSONResult.ok(carousels);
    }

    @ApiOperation(value = "获取所有一级分类", notes = "获取所有一级分类", httpMethod = "GET")
    @GetMapping("/cats")
    public DreamJSONResult cats(){
        List<Category> categories = categoryService.queryAllRootLevelCat();
        return DreamJSONResult.ok(categories);
    }

    @ApiOperation(value = "获取对应一级分类下的所有分类", notes = "获取对应一级分类下的所有分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public DreamJSONResult cats(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId
    ){
        if (rootCatId == null){
            return DreamJSONResult.errorMsg("分类不存在");
        }
        List<CategoryVO> subCatList = categoryService.getSubCatList(rootCatId);

        return DreamJSONResult.ok(subCatList);
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public DreamJSONResult sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId
    ){
        if (rootCatId == null){
            return DreamJSONResult.errorMsg("分类不存在");
        }
        List<NewItemsVO> newItemsVOS = categoryService.getSixNewItemsLazy(rootCatId);

        return DreamJSONResult.ok(newItemsVOS);
    }

}
