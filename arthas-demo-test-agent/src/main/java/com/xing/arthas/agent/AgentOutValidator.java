package com.xing.arthas.agent;

import com.xing.arthas.demo.Foo;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;

/**
 * 验证 嵌入的代码是否生效
 */
public class AgentOutValidator {
    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader(Foo.class.getName());
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new AgentBoot.MyClassVisitor(Opcodes.ASM7, cw);

        cr.accept(cv, Opcodes.ASM7);
        // 获取生成的class文件对应的二进制流
        byte[] code = cw.toByteArray();
        // 将二进制流写到out/下
        FileOutputStream fos = new FileOutputStream(AgentOutValidator.class.getResource("/").getPath().replaceAll("target/classes", "out")
                + "/FooTransForm.class");
        fos.write(code);
        fos.close();
    }
}
