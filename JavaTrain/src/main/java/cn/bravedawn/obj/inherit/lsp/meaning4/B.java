package cn.bravedawn.obj.inherit.lsp.meaning4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/27 7:47
 */
public class B extends A{

    @Override
    public HashMap fun() {
        HashMap map = new HashMap();
        System.out.println("子类的fun被执行");
        return map;
    }
}
