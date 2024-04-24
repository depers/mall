package cn.bravedawn.jvm.gc;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/3/17 21:15
 */
public class MinorGCDemo {

    /**
     * 对象优先分配到Eden区
     * VM参数：-Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8 -XX:+UseSerialGC
     */


    /**
     * 输出的GC日志
     * // 使用的是Serial GC
     * [0.005s][info][gc] Using Serial
     * [0.005s][info][gc,heap,coops] Heap address: 0x00000007be800000, size: 24 MB, Compressed Oops mode: Zero based, Oop shift amount: 3
     * // 发生了新生代GC
     * [0.080s][info][gc,start     ] GC(0) Pause Young (Allocation Failure)
     * // 新生代的Serial GC称为DefNew，将年轻代的堆内存使用量从6393K减少到了963K，分配的年轻代总大小为9216K
     * [0.081s][info][gc,heap      ] GC(0) DefNew: 6393K->963K(9216K)
     * // 老年代的堆使用量从0K扩展到了4096K，分配的老年代总大小为14336K
     * [0.081s][info][gc,heap      ] GC(0) Tenured: 0K->4096K(14336K)
     * // 元空间的使用量大小没有变化，总大小是1056768K
     * [0.081s][info][gc,metaspace ] GC(0) Metaspace: 6026K->6026K(1056768K)
     * // 进行了新生代GC，新生代的大小从6M减小到了4M，堆的总大小是23M
     * [0.081s][info][gc           ] GC(0) Pause Young (Allocation Failure) 6M->4M(23M) 1.665ms
     * [0.081s][info][gc,cpu       ] GC(0) User=0.00s Sys=0.00s Real=0.00s
     * [0.082s][info][gc,heap,exit ] Heap
     * // GC结束之后，新生代总大小是9M，已使用的是7M
     * [0.082s][info][gc,heap,exit ]  def new generation   total 9216K, used 7399K [0x00000007be800000, 0x00000007bf200000, 0x00000007bf200000)
     * // 伊甸区是8M，有6M已经被使用
     * [0.082s][info][gc,heap,exit ]   eden space 8192K,  78% used [0x00000007be800000, 0x00000007bee490f0, 0x00000007bf000000)
     * // 存活区
     * [0.082s][info][gc,heap,exit ]   from space 1024K,  94% used [0x00000007bf100000, 0x00000007bf1f0ed8, 0x00000007bf200000)
     * [0.082s][info][gc,heap,exit ]   to   space 1024K,   0% used [0x00000007bf000000, 0x00000007bf000000, 0x00000007bf100000)
     * // 老年代
     * [0.082s][info][gc,heap,exit ]  tenured generation   total 14336K, used 4096K [0x00000007bf200000, 0x00000007c0000000, 0x00000007c0000000)
     * [0.082s][info][gc,heap,exit ]    the space 14336K,  28% used [0x00000007bf200000, 0x00000007bf600020, 0x00000007bf600200, 0x00000007c0000000)
     * [0.082s][info][gc,heap,exit ]  Metaspace       used 6056K, capacity 6097K, committed 6272K, reserved 1056768K
     * [0.082s][info][gc,heap,exit ]   class space    used 528K, capacity 541K, committed 640K, reserved 1048576K
     *
     * 在分析了上述的GC日志之后，按照我们程序的逻辑，我们先创建了3个2M大小的数组，也就是6M的对象，此时我们新生代的大小其实就只有8M
     * 此时我们再创建一个4M的对象，新生代里面就放不下了，此时我们需要进行新生代GC，按照我的分析，这里将4M的原有对象直接移动到了
     * 老年代，新生代里面放着原来的2M对象和4M新的数组对象
     */
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation();
    }


    private static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        allocation4 = new byte[4 * _1M];
    }
}
