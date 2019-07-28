package com.xing.arthas.learning.trace.check;

import java.arthas.Spy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MathGameTransformer {
    private static Random random = new Random();
    public int illegalArgumentCount = 0;

    public MathGameTransformer() {
    }

    public static void main(String[] args) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        MathGameTransformer game = new MathGameTransformer();

        while (true) {
            game.run();
            TimeUnit.SECONDS.sleep(1L);
        }
    }

    public void run() throws InterruptedException, InvocationTargetException, IllegalAccessException {
        Method ON_BEFORE_METHOD = null;
        boolean var10002 = true;
        boolean var10001 = false;

        System.out.println("debug:onMethodEnter()");
        ON_BEFORE_METHOD = Spy.ON_BEFORE_METHOD;
        System.out.println("debug:onMethodEnter() >> debug:onMethodEnter() > loadAdviceMethod()");

        Object[] var12 = new Object[]{new Integer(1), this.getClass().getClassLoader(), "com/xing/arthas/learning/trace/check/MathGame", "run", "()V", this, new Object[0]};
        System.out.println("debug:onMethodEnter() >> debug:onMethodEnter() > loadAdviceMethod() >> debug:onMethodEnter() > loadAdviceMethod() > loadArrayForBefore()");
        ON_BEFORE_METHOD.invoke((Object) null, var12);
        System.out.println("debug:onMethodEnter() >> debug:onMethodEnter() > loadAdviceMethod() >> debug:onMethodEnter() > loadAdviceMethod() > loadArrayForBefore() >> debug:onMethodEnter() > loadAdviceMethod() > loadArrayForBefore() > invokeVirtual()");

        boolean var7 = true;
        var10002 = false;
        Method var9 = null;

        Method BEFORE_INVOKING_METHOD;
        boolean var10003;
        Object[] var10004;
        try {
            Object[] var15;
            try {
                int number = random.nextInt() / 10000;

                MathGameTransformer var8 = this;
                int var13 = number;
                var12 = null;
                boolean var16 = true;
                var10003 = false;
                System.out.println("debug:beforeInvoking()");
                BEFORE_INVOKING_METHOD = Spy.BEFORE_INVOKING_METHOD;
                System.out.println("debug:beforeInvoking() >> loadAdviceMethod()");
                var10004 = new Object[]{new Integer(1), "com/xing/arthas/learning/trace/check/MathGame", "primeFactors", "(I)Ljava/util/List;", new Integer(24)};
                System.out.println("debug:beforeInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing()");
                BEFORE_INVOKING_METHOD.invoke((Object) null, var10004);
                System.out.println("debug:beforeInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing() >> invokeVirtual()");
                var10002 = true;
                var16 = false;
                var15 = null;

                List var10;
                try {
                    var10 = var8.primeFactors(var13);
                } catch (Throwable var4) {
                    var9 = null;
                    var10003 = true;
                    var10002 = false;
                    System.out.println("debug:throwInvoking()");
                    var9 = Spy.THROW_INVOKING_METHOD;
                    System.out.println("debug:throwInvoking() >> loadAdviceMethod()");
                    var15 = new Object[]{new Integer(1), "com/xing/arthas/learning/trace/check/MathGame", "primeFactors", "(I)Ljava/util/List;", new Integer(24)};
                    System.out.println("debug:throwInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing()");
                    var9.invoke((Object) null, var15);
                    System.out.println("debug:throwInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing() >> invokeVirtual()");
                    var10001 = true;
                    var10003 = false;
                    var12 = null;
                    throw var4;
                }

                var9 = null;
                var10003 = true;
                var10002 = false;
                System.out.println("debug:afterInvoking()");
                var9 = Spy.AFTER_INVOKING_METHOD;
                System.out.println("debug:afterInvoking() >> loadAdviceMethod()");
                var15 = new Object[]{new Integer(1), "com/xing/arthas/learning/trace/check/MathGame", "primeFactors", "(I)Ljava/util/List;", new Integer(24)};
                System.out.println("debug:afterInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing()");
                var9.invoke((Object) null, var15);
                System.out.println("debug:afterInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing() >> invokeVirtual()");
                var10001 = true;
                var10003 = false;
                var12 = null;
                List primeFactors = var10;
                int var11 = number;
                List var17 = primeFactors;
                var12 = null;
                var16 = true;
                var10003 = false;

                System.out.println("debug:beforeInvoking()");
                BEFORE_INVOKING_METHOD = Spy.BEFORE_INVOKING_METHOD;
                System.out.println("debug:beforeInvoking() >> loadAdviceMethod()");
                var10004 = new Object[]{new Integer(1), "com/xing/arthas/learning/trace/check/MathGame", "print", "(ILjava/util/List;)V", new Integer(25)};
                System.out.println("debug:beforeInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing()");
                BEFORE_INVOKING_METHOD.invoke((Object) null, var10004);
                System.out.println("debug:beforeInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing() >> invokeVirtual()");
                var10002 = true;
                var16 = false;
                var15 = null;

                try {
                    print(var11, var17);
                } catch (Throwable var3) {
                    var9 = null;
                    var10003 = true;
                    var10002 = false;
                    System.out.println("debug:throwInvoking()");
                    var9 = Spy.THROW_INVOKING_METHOD;
                    System.out.println("debug:throwInvoking() >> loadAdviceMethod()");
                    var15 = new Object[]{new Integer(1), "com/xing/arthas/learning/trace/check/MathGame", "print", "(ILjava/util/List;)V", new Integer(25)};
                    System.out.println("debug:throwInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing()");
                    var9.invoke((Object) null, var15);
                    System.out.println("debug:throwInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing() >> invokeVirtual()");
                    var10001 = true;
                    var10003 = false;
                    var12 = null;
                    throw var3;
                }

                ON_BEFORE_METHOD = null;
                var10002 = true;
                var10001 = false;
                System.out.println("debug:afterInvoking()");
                ON_BEFORE_METHOD = Spy.AFTER_INVOKING_METHOD;
                System.out.println("debug:afterInvoking() >> loadAdviceMethod()");
                var12 = new Object[]{new Integer(1), "com/xing/arthas/learning/trace/check/MathGame", "print", "(ILjava/util/List;)V", new Integer(25)};
                System.out.println("debug:afterInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing()");
                ON_BEFORE_METHOD.invoke((Object) null, var12);
                System.out.println("debug:afterInvoking() >> loadAdviceMethod() >> loadArrayForInvokeTracing() >> invokeVirtual()");
                var7 = true;
                var10002 = false;
                var9 = null;
            } catch (Exception var5) {
                System.out.println(String.format("illegalArgumentCount:%3d, ", this.illegalArgumentCount) + var5.getMessage());
            }

            ON_BEFORE_METHOD = null;
            var10002 = true;
            var10001 = false;
            System.out.println("debug:onMethodExit()");
            System.out.println("debug:onMethodExit() >> debug:onMethodExit() > loadReturn()");
            var9 = Spy.ON_RETURN_METHOD;
            System.out.println("debug:onMethodExit() >> debug:onMethodExit() > loadReturn() >> debug:onMethodExit() > loadReturn() > loadAdviceMethod()");
            var15 = new Object[]{null};
            System.out.println("debug:onMethodExit() >> debug:onMethodExit() > loadReturn() >> debug:onMethodExit() > loadReturn() > loadAdviceMethod() >> debug:onMethodExit() > loadReturn() > loadAdviceMethod() > loadReturnArgs()");
            var9.invoke((Object) null, var15);
            System.out.println("debug:onMethodExit() >> debug:onMethodExit() > loadReturn() >> debug:onMethodExit() > loadReturn() > loadAdviceMethod() >> debug:onMethodExit() > loadReturn() > loadAdviceMethod() > loadReturnArgs() >> debug:onMethodExit() > loadReturn() > loadAdviceMethod() > loadReturnArgs() > invokeVirtual()");
            var7 = true;
            var10002 = false;
            var9 = null;
        } catch (Throwable var6) {
            var9 = null;
            var10003 = true;
            var10002 = false;
            System.out.println("debug:catchException()");
            System.out.println("debug:catchException() >> debug:catchException() > loadThrow() > loadAdviceMethod()");
            BEFORE_INVOKING_METHOD = Spy.ON_THROWS_METHOD;
            System.out.println("debug:catchException() >> debug:catchException() > loadThrow() > loadAdviceMethod() >> debug:catchException() > loadThrow() > loadAdviceMethod()");
            var10004 = new Object[]{var6};
            System.out.println("debug:catchException() >> debug:catchException() > loadThrow() > loadAdviceMethod() >> debug:catchException() > loadThrow() > loadAdviceMethod() >> debug:catchException() > loadThrow() > loadAdviceMethod() > loadThrowArgs()");
            BEFORE_INVOKING_METHOD.invoke((Object) null, var10004);
            System.out.println("debug:catchException() >> debug:catchException() > loadThrow() > loadAdviceMethod() >> debug:catchException() > loadThrow() > loadAdviceMethod() >> debug:catchException() > loadThrow() > loadAdviceMethod() > loadThrowArgs() >> debug:catchException() > loadThrow() > loadAdviceMethod() > loadThrowArgs() > invokeVirtual()");
            var10001 = true;
            var10003 = false;
            var12 = null;
            throw var6;
        }
    }

    public static void print(int number, List<Integer> primeFactors) {
        StringBuffer sb = new StringBuffer(number + "=");
        Iterator var3 = primeFactors.iterator();

        while (var3.hasNext()) {
            int factor = (Integer) var3.next();
            sb.append(factor).append('*');
        }

        if (sb.charAt(sb.length() - 1) == '*') {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb);
    }

    public List<Integer> primeFactors(int number) {
        if (number < 2) {
            ++this.illegalArgumentCount;
            throw new IllegalArgumentException("number is: " + number + ", need >= 2");
        } else {
            List<Integer> result = new ArrayList();
            int i = 2;

            while (i <= number) {
                if (number % i == 0) {
                    result.add(i);
                    number /= i;
                    i = 2;
                } else {
                    ++i;
                }
            }

            return result;
        }
    }
}