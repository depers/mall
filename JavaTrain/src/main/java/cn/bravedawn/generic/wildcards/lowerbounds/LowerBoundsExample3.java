package cn.bravedawn.generic.wildcards.lowerbounds;

import cn.bravedawn.generic.wildcards.Animal;
import cn.bravedawn.generic.wildcards.Dog;
import cn.bravedawn.generic.wildcards.HsqDog;
import cn.bravedawn.generic.wildcards.SmyDog;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundsExample3 {

    /**
     * 我们现在有一个场景，将src列表的元素复制到dest列表中
     * @param dest 目标列表
     * @param src 源列表
     */
    public static void copyHappyDog(List<? super Dog> dest, List<? extends Dog> src) {
        for (Dog dog : src) {
            dest.add(dog);
        }
    }


    /**
     * copyHappyDog()方法的dest参数使用 下边界符 进行限定，Dog父类的列表都可以接受
     */
    public static void main(String[] args) {

        copyHappyDog(new ArrayList<Dog>(), new ArrayList<Dog>());
        copyHappyDog(new ArrayList<Dog>(), new ArrayList<HsqDog>());
        copyHappyDog(new ArrayList<Dog>(), new ArrayList<SmyDog>());
        copyHappyDog(new ArrayList<Animal>(), new ArrayList<SmyDog>());
        copyHappyDog(new ArrayList<Object>(), new ArrayList<SmyDog>());
    }

}
