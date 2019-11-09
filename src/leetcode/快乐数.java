package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 武凯焱
 * @date 2019/8/3 14:55
 * @Description:
 */
public class 快乐数 {
   /* public static void main(String[] args) {
        System.out.println(isHappy(21));
    }

    public static  boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        int result =n;
        while (result!=1){
            if (set.contains(result)){
                return false;
            }else {
                set.add(result);
            }
            result = powNum(result);
        }
        return true;

    }
    public static int powNum(int m){
        int num = 0;
        while (m != 0) {
            num += (int) Math.pow(m % 10, 2);
            m /= 10;
        }
        return num;
    }*/
   static Set<Integer> set = new HashSet<>();
    public static boolean isHappy(int n) {
        if(n <= 0) return false;
        int size = set.size();
        char[] chars = Integer.toString(n).toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i] - 48;
            result += a * a;
        }
        System.out.println(result);
        if(result == 1) return true;
        set.add(n);
        if(size == set.size()) return false;
        boolean res = isHappy(result);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(23));
    }

}
