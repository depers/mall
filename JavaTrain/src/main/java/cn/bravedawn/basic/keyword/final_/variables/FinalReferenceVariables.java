package cn.bravedawn.basic.keyword.final_.variables;

import cn.bravedawn.basic.keyword.final_.class_.Cat;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 14:03
 */
public class FinalReferenceVariables {

    public static void main(String[] args) {
        final Cat cat = new Cat(1);

        // 不能修改i
        // cat = new Cat(2);

        // 这里我们可以修改对象的属性
        cat.setWeight(12);
        System.out.println(cat);
    }
}
