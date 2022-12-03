package cn.bravedawn.collection.list.copylist.commonslang3;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/29 13:03
 */
public class CommonsLang3Clone {

    /**
     * 使用Apache Commons Lang等第三方库提供的clone方法（深拷贝）实现List的复制
     */

    public static void main(String[] args) {
        Plant p1 = new Plant("杜鹃", "red", new Date());
        Plant p2 = new Plant("玫瑰", "yellow", new Date());
        Plant p3 = new Plant("月季", "pink", new Date());
        List<Plant> plantList = new ArrayList<>();
        plantList.add(p1);
        plantList.add(p2);
        plantList.add(p3);
        System.out.println("plants = " + plantList);

        List<Plant> plantsCopy = new ArrayList<>();
        for (Plant plant : plantList) {
            plantsCopy.add(SerializationUtils.clone(plant));
        }
        System.out.println("plantsCopy = " + plantsCopy);

        // 修改列表中一个元素的属性
        Plant plant = plantsCopy.get(1);
        plant.setColor("white");
        Date date = new Date();
        date.setYear(200);
        plant.setFlorescence(date);
        System.out.println("Modified plants = " + plantList);
        System.out.println("Modified plantsCopy = " + plantsCopy);
    }
}
