package cn.bravedawn.generic.wildcards.upperbounds;

import cn.bravedawn.generic.wildcards.Animal;
import cn.bravedawn.generic.wildcards.Cat;
import cn.bravedawn.generic.wildcards.Dog;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundsExample {

    /**
     * 为什么要让泛型实现协变
     * 如下面的代码所示，是为了实现多态
     */

    public static void main(String[] args) {
        process(new ArrayList<Animal>());
        //process(new ArrayList<Dog>()); // 编译错误
        //process(new ArrayList<Cat>()); // 编译错误
    }


    public static void process(List<Animal> list) {
        System.out.println("...");
    }



}
