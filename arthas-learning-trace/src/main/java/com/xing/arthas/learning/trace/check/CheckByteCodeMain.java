package com.xing.arthas.learning.trace.check;

import com.xing.arthas.learning.trace.AdviceWeaver;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.FileOutputStream;

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

/**
 * check生成的字节码文件
 */
public class CheckByteCodeMain {
    public static void main(String[] args) throws Exception{
        final ClassReader cr = new ClassReader(MathGame.class.getName());
        // 字节码增强
        final ClassWriter cw = new ClassWriter(cr, COMPUTE_FRAMES | COMPUTE_MAXS);

        int adviceId = 1;
        boolean isTracing = true;
        boolean skipJDKTrace = true;
        // 生成增强字节码
        cr.accept(new AdviceWeaver(adviceId, isTracing, skipJDKTrace, cr.getClassName(), cw), EXPAND_FRAMES);

        final byte[] enhanceClassByteArray = cw.toByteArray();

        FileOutputStream fos = new FileOutputStream(MathGame.class.getResource("/").getPath().replaceAll("target/classes", "out")
                + "/MathGameTransformer.class");
        fos.write(enhanceClassByteArray);
        fos.close();
    }
}
