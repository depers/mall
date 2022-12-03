package cn.bravedawn.collection.list.copylist.clonemethod;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/28 21:51
 */
public class CopyListForCloneMethod {

    /**
     * 通过覆盖可变类的clone方法实现，即深拷贝实现list的复制
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        Date now = new Date();
        Plant p1 = new Plant("杜鹃", "red", now);
        Plant p2 = new Plant("玫瑰", "yellow", now);
        Plant p3 = new Plant("月季", "pink", now);
        List<Plant> plantList = new ArrayList<>();
        plantList.add(p1);
        plantList.add(p2);
        plantList.add(p3);
        System.out.println("plants = " + plantList);


        List<Plant> plantsCopy = new ArrayList<>();
        for (Plant plant : plantList) {
            plantsCopy.add((Plant) plant.clone());
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
