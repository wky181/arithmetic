package leetcode;

import java.util.ArrayDeque;

/**
 * @Author: wky233
 * @Date: 2020/5/7 9:40
 * @Description:
 */
public class LeetCode_7 {
    public static void main(String[] args) {
        int ans = 0;
        int x = -123;
        while (x != 0){
            int num = x % 10;
            System.out.println(num);
            ans = ans * 10 + num;

            x /= 10;

        }
        System.out.println(ans);
    }
    public int reverse(int x) {
        int ans = 0;
        while (x != 0){
            int num = x % 10;
            // 防止向上越界 7 是Integer.MAX_VALUE的最后一位数
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > 7) ){
                return 0;
            }
            // 防止向下越界 8 是Integer.MIN_VALUE的最后一位数
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && num > 8)){
                return 0;
            }
            ans = ans * 10 + num;
            x /= 10;
        }
        return ans;
    }
}
