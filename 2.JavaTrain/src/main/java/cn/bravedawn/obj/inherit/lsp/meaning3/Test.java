package cn.bravedawn.obj.inherit.lsp.meaning3;

import java.util.HashMap;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/24 15:47
 */
public class Test {

    /**
     * 当子类的方法<b>重载</b>父类的方法时，方法的前置条件（即方法的输入/入参）要比父类方法的输入参数更宽松（<b>大于<b>）。
     * （例如父类方法的入参为HashMap，则子类的入参应该为Map）
     */

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        Child child = new Child();
        child.method(hashMap); // 父类被执行

        Child2 child3 = new Child2();
        child3.method(hashMap); // 子类Map入参方法被执行
    }


}
