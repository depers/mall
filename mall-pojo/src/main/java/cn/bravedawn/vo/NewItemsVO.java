package cn.bravedawn.vo;

import lombok.Data;

import java.util.List;

/**
 * 最新商品VO
 * @Author 冯晓
 * @Date 2020/1/7 10:17
 */
@Data
public class NewItemsVO {

    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;

    private List<SimpleItemVO> simpleItemList;
}
