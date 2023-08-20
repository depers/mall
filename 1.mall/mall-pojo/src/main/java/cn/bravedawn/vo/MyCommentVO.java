package cn.bravedawn.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author 冯晓
 * @Date 2020/3/28 16:05
 */
@Data
public class MyCommentVO {

    private String commentId;
    private String content;
    private Date createdTime;
    private String itemId;
    private String itemName;
    private String specName;
    private String itemImg;

}
