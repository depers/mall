package cn.bravedawn.vo;

import lombok.Data;

/**
 * @Author 冯晓
 * @Date 2020/1/14 15:32
 * @Title 用于展示商品搜索列表结果的VO
 */
@Data
public class SearchItemsVO {

    private String itemId;
    private String itemName;
    private int sellCounts;
    private String imgUrl;

    // 这里需要说明的就是，在数据库的价格设计为int，业务端的类型也为int，除100的操作在前端进行
    private int price;
}
