package com.xing.arthas.agent;

import com.xing.arthas.demo.Foo;
import org.objectweb.asm.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;

import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class AgentBoot {

    public static void premain(String args, Instrumentation inst) {
        main(args, inst);
    }

    public static void agentmain(String args, Instrumentation inst) {
        main(args, inst);
    }

    public static void main(String args, final Instrumentation inst) {
        inst.addTransformer(new MyTransformer(), true);
        try {
            inst.retransformClasses(Foo.class);
        } catch (UnmodifiableClassException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Agent Main Done");

    }

    static class MyTransformer implements ClassFileTransformer {

        public byte[] transform(ClassLoader loader,
                                String className,
                                Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain,
                                byte[] classfileBuffer) throws IllegalClassFormatException {
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);

            cr.accept(new MyClassVisitor(Opcodes.ASM7, cw), ClassReader.EXPAND_FRAMES);
            return cw.toByteArray();
        }
    }

    static class MyClassVisitor extends ClassVisitor {

        public MyClassVisitor(int api) {
            super(api);
        }

        public MyClassVisitor(int api, ClassVisitor classVisitor) {
            super(api, classVisitor);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            if ("getDesc".equals(name)) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MyMethodVisitor(Opcodes.ASM7, mv);
            }
            return super.visitMethod(access, name, descriptor, signature, exceptions);
        }
    }

    static class MyMethodVisitor extends MethodVisitor {

        public MyMethodVisitor(int api) {
            super(api);
        }

        public MyMethodVisitor(int api, MethodVisitor methodVisitor) {
            super(api, methodVisitor);
        }

        // 方法开始时调用
        @Override
        public void visitCode() {
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Hello Foo.getDesc!!");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            super.visitCode();
        }

        // 方法结束时调用
        @Override
        public void visitInsn(int i) {
            super.visitInsn(i);
        }
    }
}
