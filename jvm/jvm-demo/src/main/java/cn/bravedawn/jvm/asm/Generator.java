package cn.bravedawn.jvm.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/7 16:39
 */
public class Generator {


    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("cn/bravedawn/jvm/asm/Main");

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor cv = new MyClassVisitor2(cw);

        cr.accept(cv, ClassReader.SKIP_DEBUG);

        byte[] data = cw.toByteArray();

        // 输出
        File f = new File("/Users/depers/Desktop/code/mall/jvm/jvm-demo/target/classes/cn/bravedawn/jvm/asm/Main.class");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(data);
        fos.close();
    }
}
