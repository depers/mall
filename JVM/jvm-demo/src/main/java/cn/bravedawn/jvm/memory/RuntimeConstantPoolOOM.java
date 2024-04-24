package cn.bravedawn.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/3/5 10:30
 */
public class RuntimeConstantPoolOOM {

    /**
     * 方法区和运行时常量池溢出的具体实践
     * 虚拟机参数：-XX:PermSize=10m -XX:MaxPermSize=10m，这两个参数再JDK1.8中已经被废除了
     */

    public static void main(String[] args) {
        // 声明一个List保存常量池中字符串引用，避免Full GC收回常量池的行为
        List<String> list = new ArrayList<>();

        int i = 0;
        while(true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
