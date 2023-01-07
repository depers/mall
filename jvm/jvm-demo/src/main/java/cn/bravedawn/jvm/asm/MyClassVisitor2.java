package cn.bravedawn.jvm.asm;

import org.objectweb.asm.*;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/7 16:12
 */
public class MyClassVisitor2 extends ClassVisitor {

    /**
     * 推荐使用这种方式，编码相对简单一些
     */


    protected MyClassVisitor2(ClassVisitor classVisitor) {
        super(Opcodes.ASM9, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

        if (!"<init>".equals(name) && mv != null) {
            // 为这样的方法增加记录方法执行时间的功能
            mv = new MyMethodVisitor(mv);
        }


        return mv;
    }


    class MyMethodVisitor extends MethodVisitor {

        protected MyMethodVisitor(MethodVisitor methodVisitor) {
            super(Opcodes.ASM9, methodVisitor);
        }


        /**
         * 代码开始执行的地方
         */
        @Override
        public void visitCode() {
            mv.visitCode();

            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "cn/bravedawn/jvm/asm/MyTimeLogger", "start", "()V", false);
        }


        /**
         * 代码结束执行的地方
         */
        @Override
        public void visitInsn(int opcode) {
            if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN || opcode == Opcodes.ATHROW) {
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "cn/bravedawn/jvm/asm/MyTimeLogger", "end", "()V", false);
            }

            mv.visitInsn(opcode);
        }
    }
}
