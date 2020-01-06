package cn.bravedawn.service;

import cn.bravedawn.pojo.Category;
import cn.bravedawn.vo.CategoryVO;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/6 15:23
 */
public interface CategoryService {

    /**
     * 查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);
}
