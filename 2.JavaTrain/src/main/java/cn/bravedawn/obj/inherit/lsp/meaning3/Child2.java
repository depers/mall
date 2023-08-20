package cn.bravedawn.obj.inherit.lsp.meaning3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/24 15:44
 */
public class Child2 extends Parent2{

    public void method(HashMap map) {
        System.out.println("子类Map入参方法被执行");
    }
}
