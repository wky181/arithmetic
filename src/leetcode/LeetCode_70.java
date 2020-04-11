package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/19 23:27
 * @Description:
 */
public class LeetCode_70 {
    public static void main(String[] args) {

    }
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int numpre = 1;
        int pre = 2;
        for (int i = 3; i <= n ; i++) {
            int temp = pre;
            pre = numpre + pre;
            numpre = temp;
        }
        return pre;
    }
}
