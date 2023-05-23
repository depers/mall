package cn.bravedawn.io.systemout;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/5/23 16:54
 */
public class SystemOutExample {

    /**
     * 最近在阅读《深入理解Java虚拟机第三版》的时候读到了一段话：
     * *标准输出（System.out）和标准错误输出（System.err）中打印的信息收集起来。但标准输出设备是整个虚拟机进程全局共享的资源，
     * 如果使用`System.setOut()`/`System.setErr()`方法把输出流重定向到自己定义的`PrintStream`对象上固然可以收集到输出信息，
     * 但也会对原有程序产生影响：会把其他线程向标准输出中打印的信息也收集了。*
     *
     * 所以我准备做个实验，这个类的作用是重定向输出流将内容输出到文件中
     * 实验步骤：
     *  1.启动cn.bravedawn.io.systemout.WhilePrint
     *  2.接着启动cn.bravedawn.io.systemout.SystemOutExample
     *
     * 实验结果：
     *  上面的这段话我没实验出来，这个问题先搁置吧，后面遇到了再说
     */

    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.println("Hello World!");
        }
    }
}
