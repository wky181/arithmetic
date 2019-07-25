package 真题;

import java.util.Vector;

/**
 * @author 武凯焱
 * @date 2019/3/22 21:00
 * @Description:
 */
public class 循环节长度_15 {
    public static void main(String[] args) {
        System.out.println(f(11,13));
    }
    public static int f(int n, int m)
    {
        n = n % m;
        Vector v = new Vector();
        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) return 0;
            if(v.indexOf(n)>=0) return   v.size()-v.indexOf(n);  //填空
        }
    }
}
