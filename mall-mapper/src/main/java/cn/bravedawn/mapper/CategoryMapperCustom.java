package cn.bravedawn.mapper;

import cn.bravedawn.vo.CategoryVO;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/6 15:54
 */
public interface CategoryMapperCustom {

    List<CategoryVO> getSubCatList(Integer rootCatId);
}
