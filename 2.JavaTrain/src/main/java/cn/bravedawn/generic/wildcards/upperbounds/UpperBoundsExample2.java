package cn.bravedawn.generic.wildcards.upperbounds;

import cn.bravedawn.generic.wildcards.Animal;
import cn.bravedawn.generic.wildcards.Cat;
import cn.bravedawn.generic.wildcards.Dog;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundsExample2 {

    /**
     * 为什么要让泛型实现协变
     * 如下面的代码所示，为了让方法process接受Animal子类的集合，我们使用了extends关键字
     * 其中？被称为通配符，用来表示不确定的类型
     *  通配符和extends关键字组成了Java泛型的上界描述符
     */

    public static void main(String[] args) {
        process(new ArrayList<Animal>());
        process(new ArrayList<Dog>());
        process(new ArrayList<Cat>());
    }


    public static void process(List<? extends Animal> list) {
        Animal animal = list.get(0);
        System.out.println("...");
    }



}
