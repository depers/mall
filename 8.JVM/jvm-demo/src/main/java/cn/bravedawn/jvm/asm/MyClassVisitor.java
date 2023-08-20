package cn.bravedawn.jvm.asm;

import org.objectweb.asm.*;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/1/7 16:12
 */
public class MyClassVisitor extends ClassVisitor {


    protected MyClassVisitor(ClassVisitor classVisitor) {
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

            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(Opcodes.LSTORE, 1);
        }


        /**
         * 代码结束执行的地方
         */
        @Override
        public void visitInsn(int opcode) {
            if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN || opcode == Opcodes.ATHROW) {
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
                mv.visitVarInsn(Opcodes.LSTORE, 3);
                Label label4 = new Label();
                mv.visitLabel(label4);
                mv.visitLineNumber(16, label4);
                mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitVarInsn(Opcodes.LLOAD, 3);
                mv.visitVarInsn(Opcodes.LLOAD, 1);
                mv.visitInsn(Opcodes.LSUB);
                mv.visitInvokeDynamicInsn("makeConcatWithConstants", "(J)Ljava/lang/String;",
                        new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), new Object[]{"method test consume time is \u0001"});
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            }

            mv.visitInsn(opcode);
        }
    }
}
