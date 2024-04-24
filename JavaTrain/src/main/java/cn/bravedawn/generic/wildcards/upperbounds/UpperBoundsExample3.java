package cn.bravedawn.generic.wildcards.upperbounds;

import cn.bravedawn.generic.wildcards.Animal;
import cn.bravedawn.generic.wildcards.Cat;
import cn.bravedawn.generic.wildcards.Dog;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundsExample3 {

    /**
     * 泛型的上界描述符，只运行读取，不允许插入(null除外)
     */

    public static void main(String[] args) {
        List<? extends Animal> animals = new ArrayList<>();
        animals.add(null);

        //animals.add(new Dog()); // 编译错误
        //animals.add(new Cat()); // 编译错误
    }
}
