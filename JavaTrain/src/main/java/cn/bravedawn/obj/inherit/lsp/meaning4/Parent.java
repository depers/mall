package cn.bravedawn.obj.inherit.lsp.meaning4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/27 7:51
 */
public class Parent {

    public HashMap fun() {
        System.out.println("父类fun被执行");
        return new HashMap();
    }
}
