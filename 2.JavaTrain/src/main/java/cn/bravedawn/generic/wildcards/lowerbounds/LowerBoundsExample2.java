package cn.bravedawn.generic.wildcards.lowerbounds;

import cn.bravedawn.generic.wildcards.Animal;
import cn.bravedawn.generic.wildcards.Dog;
import cn.bravedawn.generic.wildcards.HsqDog;
import cn.bravedawn.generic.wildcards.SmyDog;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundsExample2 {

    /**
     * 我们现在有一个场景，将src列表的元素复制到dest列表中
     * @param dest 目标列表
     * @param src 源列表
     */
    public static void copyHappyDog(List<Dog> dest, List<? extends Dog> src) {
        for (Dog dog : src) {
            dest.add(dog);
        }
    }


    /**
     * copyHappyDog()方法的src参数使用上边界符进行限定，Dog子类的列表都可以接受
     * 但是如果参数dest传递Dog父类的集合就会编译失败
     */
    public static void main(String[] args) {

        copyHappyDog(new ArrayList<Dog>(), new ArrayList<Dog>());
        copyHappyDog(new ArrayList<Dog>(), new ArrayList<HsqDog>());
        copyHappyDog(new ArrayList<Dog>(), new ArrayList<SmyDog>());
        //copyHappyDog(new ArrayList<Animal>(), new ArrayList<SmyDog>()); // 编译失败
        //copyHappyDog(new ArrayList<Object>(), new ArrayList<SmyDog>()); // 编译失败
    }

}
