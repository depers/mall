package cn.bravedawn.service;

import cn.bravedawn.pojo.Carousel;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/6 15:05
 */
public interface CarouselService {


    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    List<Carousel> queryAll(Integer isShow);
}
