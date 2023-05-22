package cn.bravedawn.jvm.codetracer;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/21 15:19
 */
public class HotSwapClassLoader extends ClassLoader{

    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
