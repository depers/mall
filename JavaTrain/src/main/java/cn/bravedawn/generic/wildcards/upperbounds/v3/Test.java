package cn.bravedawn.generic.wildcards.upperbounds.v3;

import cn.bravedawn.generic.wildcards.upperbounds.comm.Apple;
import cn.bravedawn.generic.wildcards.upperbounds.comm.Fruit;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 21:42
 */
public class Test {


    /**
     * <? extends T>作为泛型变量声明时使用时，不能进行写操作
     */


    public static void main(String[] args) {
        Plate<Apple> p = new Plate<Apple>(new Apple());

        // 装苹果的盘子”无法转换成“装水果的盘子
        // Plate<Fruit> p2 = new Plate<Apple>(new Apple()); //compile error

        // <? extends T>作为泛型变量声明时使用
        Plate<? extends Fruit> plate = new Plate<>(new Apple());

        // 使用 extends 通配符不能进行 写操作
        //plate.set(new Fruit());
        //plate.set(new Apple());

        // 这里使用get可以获取到具体类型的元素
        Fruit fruit = plate.get();
        Object obj = plate.get();
    }
}
