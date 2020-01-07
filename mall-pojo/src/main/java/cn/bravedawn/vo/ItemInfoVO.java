package cn.bravedawn.vo;

import cn.bravedawn.pojo.Items;
import cn.bravedawn.pojo.ItemsImg;
import cn.bravedawn.pojo.ItemsParam;
import cn.bravedawn.pojo.ItemsSpec;
import lombok.Data;

import java.util.List;

/**
 * 商品详情VO
 * @Author 冯晓
 * @Date 2020/1/7 14:16
 */
@Data
public class ItemInfoVO {

    private Items item;
    private List<ItemsImg> itemImgList;
    private List<ItemsSpec> itemSpecList;
    private ItemsParam itemParams;
}
