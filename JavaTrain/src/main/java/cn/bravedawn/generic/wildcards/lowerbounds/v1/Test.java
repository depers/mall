package cn.bravedawn.generic.wildcards.lowerbounds.v1;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 22:02
 */
public class Test {


    public static void main(String[] args) {
        Plate<? super Apple> p = new Plate<>(new Food());

        // 这里我们可以set的元素可以是Apple的子类和她自己，他的父类是不行的，原因是我不知道他的父类有哪些

        p.set(new Apple());
        p.set(new AsianApple());
        // p.set(new Food());
        // p.set(new Fruit());


        // 这里不能够获取具体类型的元素
        Object object = p.get();
        Apple a = (Apple) p.get();
    }
}
