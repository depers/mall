package cn.bravedawn.generic.wildcards.lowerbounds;

import cn.bravedawn.generic.wildcards.Dog;
import cn.bravedawn.generic.wildcards.HsqDog;
import cn.bravedawn.generic.wildcards.SmyDog;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundsExample {

    /**
     * 我们现在有一个场景，将src列表的元素复制到dest列表中
     * @param dest 目标列表
     * @param src 源列表
     */
    public static void copyHappyDog(List<Dog> dest, List<Dog> src) {
        for (Dog dog : src) {
            dest.add(dog);
        }
    }


    /**
     * 如果将Dog子类的集合传入到src中就会编译失败
     */
    public static void main(String[] args) {

        copyHappyDog(new ArrayList<Dog>(), new ArrayList<Dog>());
        //copyHappyDog(new ArrayList<Dog>(), new ArrayList<HsqDog>()); // 编译失败
        //copyHappyDog(new ArrayList<Dog>(), new ArrayList<SmyDog>()); // 编译失败
    }
}
