package cn.bravedawn.vo;

import lombok.Data;

import java.util.List;

/**
 * 二级分类VO
 * @Author 冯晓
 * @Date 2020/1/6 15:47
 */

@Data
public class CategoryVO {
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;

    // 三级分类vo list
    private List<SubCategoryVO> subCatList;
}
