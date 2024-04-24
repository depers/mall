package cn.bravedawn.generic.variant;

import cn.bravedawn.basic.keyword.final_.class_.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/14 21:52
 */
public class VariantExample {

    /**
     * 由此可见，泛型只支持不变
     */


    public static void main(String[] args) {
        // 协变
        // List<Animal> animalList = new ArrayList<Dog>();

        // 逆变
        // List<Dog> dogList = new ArrayList<Animal>();

        // 不变
        List<Animal> list = new ArrayList<Animal>();
    }


    public void test() {
        // Java为什么不支持协变，如果支持协变，那我就可以随便将其它类型的对象放到List中，要知道在Java的List中只能放置同一类型的对象。
        // List<Animal> animalList = new ArrayList<Dog>();
        // animalList.add(new Dog());
        // animalList.add(new Cat());
    }
}
