package cn.bravedawn.generic.wildcards.upperbounds;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 21:42
 */
public class Test {


    public static void main(String[] args) {
        Plate<Apple> p = new Plate<Apple>(new Apple());

        // 装苹果的盘子”无法转换成“装水果的盘子
        // Plate<Fruit> p2 = new Plate<Apple>(new Apple()); //compile error

        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());

        // 这里使用set会报错，我的理解是Plate<? extends Fruit>代表某个只能放某种类型水果的盘子，而不是什么水果都能往里放的盘子
        // plate.set(new Fruit());
        //plate.set(new Apple());

        Fruit fruit = plate.get();
        Object obj = plate.get();
    }
}
