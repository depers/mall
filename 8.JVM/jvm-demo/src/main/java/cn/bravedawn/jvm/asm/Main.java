package cn.bravedawn.jvm.asm;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/7 15:19
 */
public class Main {

    public void test() throws Exception{
        System.out.println("now in method test ---->");
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();
    }
}
