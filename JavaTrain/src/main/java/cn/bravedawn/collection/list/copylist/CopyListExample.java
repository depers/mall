package cn.bravedawn.collection.list.copylist;

import java.util.ArrayList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 16:52
 */
public class CopyListExample {

    /**
     * 拷贝列表中的元素到另一个列表：第一种方法使用结构体参数传入
     */

    public static void main(String[] args) {

        /**
         * 注意：下面这段代码我们复制的是列表中每个对象的引用，并不是克隆对象，所以对列表中某一个元素的修改，会同步提现在两个列表中
         */

        Plant p1 = new Plant("杜鹃", "red");
        Plant p2 = new Plant("玫瑰", "yellow");
        Plant p3 = new Plant("月季", "pink");

        List<Plant> plants = new ArrayList<>();
        plants.add(p1);
        plants.add(p2);
        plants.add(p3);
        System.out.println("plants = " + plants);

        // 复制
        List<Plant> plantsCopy = new ArrayList<>(plants);
        System.out.println("plantsCopy = " + plantsCopy);

        // 修改列表中一个元素的属性
        plantsCopy.get(1).setColor("white");
        System.out.println("Modified plants = " + plants);
        System.out.println("Modified plantsCopy = " + plantsCopy);

        // -----------------------------------------------------------

        /**
         * Integer是一个不可变类，他在实例创建的时候就会被赋值，后面是不会发生改变的
         * 在下面的实验中，修改之后的list与复制的list之间没有关系，不会发生同步情况
         */

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("integer list = " + list);

        List<Integer> copy = new ArrayList<>(list);
        System.out.println("integer copy list = " + copy);

        list.set(1, 0);
        System.out.println("Modified list = " + list);
        System.out.println("Modified copy list = " + copy);

    }

}
