package LeetCodeSecond.unionfind;

import java.util.Random;

/**
 * @Author: wky233
 * @Date: 2020/6/7 9:31
 * @Description:
 */
public class UFTest {
    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
        UFDemo ufDemo = new UFDemo(size);
        UFDemo2 ufDemo2 = new UFDemo2(size);
        UFDemo3 ufDemo3 = new UFDemo3(size);
        UFDemo4 ufDemo4 = new UFDemo4(size);
        UFDemo5 ufDemo5 = new UFDemo5(size);
        UFDemo6 ufDemo6 = new UFDemo6(size);
       /* System.out.println(" UFDemo " + testUF(ufDemo,m) + "s");
        System.out.println(" UFDemo2 " + testUF(ufDemo2,m) + "s");*/
        System.out.println(" UFDemo3 " + testUF(ufDemo3,m) + "s");
        System.out.println(" UFDemo4 " + testUF(ufDemo4,m) + "s");
        System.out.println(" UFDemo5 " + testUF(ufDemo5,m) + "s");
        System.out.println(" UFDemo6 " + testUF(ufDemo6,m) + "s");


    }
    private static double testUF(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();
        // 单位纳秒
        long startTime = System.nanoTime();
        for (int i = 0; i < m ; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }
        for (int i = 0; i < m ; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
