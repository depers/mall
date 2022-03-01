package cn.bravedawn.generic.wildcards.upperbounds.v1;

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

        Plate<? extends Fruit> plate = new Plate<>(new Apple());

        // 这里使用set会报错，<? extends Fruit>告诉编译器我们要处理Fruit类型的子类，但是我们不知道Fruit子类有哪些（包括他自己）
        //plate.set(new Fruit());
        //plate.set(new Apple());

        // 这里使用get可以获取到具体类型的元素
        Fruit fruit = plate.get();
        Object obj = plate.get();
    }
}
