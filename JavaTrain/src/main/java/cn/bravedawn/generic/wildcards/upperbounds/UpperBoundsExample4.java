package cn.bravedawn.generic.wildcards.upperbounds;

import cn.bravedawn.generic.wildcards.Animal;
import cn.bravedawn.generic.wildcards.Dog;

import java.util.ArrayList;
import java.util.Collection;

public class UpperBoundsExample4 {

    /**
     * Collection的泛型设计
     * 下面的三个方法中，可以看到只有add方法的参数使用了泛型，这是因为add方法是写入操作，泛型的上界描述符不允许进行插入，可以通过泛型对插入的数据进行校验。
     * 而contains和remove方法是没有使用泛型的，是因为这两个方法都是不是写入操作，所以不需要做泛型类型的控制。
     *
     * 1. boolean add(E e);
     * 2. boolean contains(Object o);
     * 3. boolean remove(Object o);
     */


    public static void main(String[] args) {
        Collection<? extends Animal> animals = new ArrayList<>();
        Dog dog = new Dog();

        //animals.add(dog);  // 编译错误
        animals.contains(dog);
        animals.remove(dog);
    }
}
