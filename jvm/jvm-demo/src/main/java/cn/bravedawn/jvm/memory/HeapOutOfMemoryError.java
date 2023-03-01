package cn.bravedawn.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/3/1 21:06
 */
public class HeapOutOfMemoryError {


    /**
     * 演示Java堆的溢出情况
     * 虚拟机执行参数：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */


    static class OOMObject{

    }


    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
