package cn.bravedawn.generic.wildcards.lowerbounds.v1;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 22:02
 */
public class Test {

    /**
     * 泛型只能用于泛型类，泛型方法，泛型接口的声明，不能用做泛型变量的声明
     */


    public static void main(String[] args) {
        Plate<? super Apple> p = new Plate<>(new Food());

        // 这里我们可以set的元素可以是Apple的子类和她自己，他的父类是不行的，原因是我不知道他的父类有哪些
        // 所以说super关键字在这里的作用是失效的

        p.set(new Apple());
        p.set(new AsianApple());
         //p.set(new Food());
         //p.set(new Fruit());
    }
}
