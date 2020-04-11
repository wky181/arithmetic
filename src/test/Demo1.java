package test;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wky233
 * @Date: 2020/2/6 15:17
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) throws NoSuchFieldException {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        //把当前对象引用当做key
        threadLocal.set(1);
        int value = 0;
        Integer i1 = Integer.valueOf(123);
        Integer i2 = new Integer(123);
        Integer i3 = new Integer(123);
        Integer i4 = 123;
        System.out.println(i2 == i3); // false
        System.out.println(i1 == i4); // true
        System.out.println(i1 == i2); // false
        List list = new ArrayList();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        Unsafe unsafe = Unsafe.getUnsafe();
        long offset = unsafe.objectFieldOffset(Demo.class.getDeclaredField("value"));

    }
}
