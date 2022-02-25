package cn.bravedawn.generic.wildcards.lowerbounds;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 22:02
 */
public class Test {


    public static void main(String[] args) {
        Plate<? super Apple> p = new Plate<>(new Food());

        p.set(new Apple());
        p.set(new Food());
        p.set(new Fruit());
    }
}
