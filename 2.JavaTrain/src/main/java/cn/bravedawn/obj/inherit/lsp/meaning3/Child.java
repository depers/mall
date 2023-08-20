package cn.bravedawn.obj.inherit.lsp.meaning3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/24 15:44
 */
public class Child extends Parent{

    public void method(Map map) {
        System.out.println("子类Map入参方法被执行");
    }
}
