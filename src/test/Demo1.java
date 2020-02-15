package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/2/6 15:17
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(123);
        Integer i2 = new Integer(123);
        Integer i3 = new Integer(123);
        Integer i4 = 123;
        System.out.println(i2 == i3); // false
        System.out.println(i1 == i4); // true
        System.out.println(i1 == i2); // false
        List list = new ArrayList();

    }
}
