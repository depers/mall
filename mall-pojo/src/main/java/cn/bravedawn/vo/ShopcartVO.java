package cn.bravedawn.vo;

import lombok.Data;

/**
 * @Author 冯晓
 * @Date 2020/1/15 21:13
 */
@Data
public class ShopcartVO {

    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String priceDiscount;
    private String priceNormal;
}
