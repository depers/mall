package cn.bravedawn.bo;

import lombok.Data;

/**
 * @Author 冯晓
 * @Date 2020/1/15 13:40
 */
@Data
public class ShopcartBO {

    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private Integer buyCounts;
    private String priceDiscount;
    private String priceNormal;
}
