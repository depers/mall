package cn.bravedawn.jvm.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/4/20 21:30
 */
public class JConsoleTestCase {


    /**
     * VM参数：-Xms100m -Xmx100m -XX:+UseSerialGC
     * 内存占位符对象，一个OOMObject大约占64KB
     * 这个例子主要延时JConsole的 [内存] 页的功能，我们可以在内存页查看新生代、老年代的内存使用情况
     */

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }


    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更为明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }


    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
