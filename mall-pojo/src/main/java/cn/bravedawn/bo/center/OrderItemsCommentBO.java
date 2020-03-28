package cn.bravedawn.bo.center;

import lombok.Data;

/**
 * @Author 冯晓
 * @Date 2020/3/28 15:45
 */
@Data
public class OrderItemsCommentBO {

    private String commentId;
    private String itemId;
    private String itemName;
    private String itemSpecId;
    private String itemSpecName;
    private Integer commentLevel;
    private String content;
}
