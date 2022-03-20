package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/20 0:07
 * @Description:
 */
public class LeetCoed_9 {
    public boolean isPalindrome(int x) {
        if(x <= 0){
            return false;
        }
        int ans = 0;
        while (x > 0){
            ans = ans *10 + x %10;
            x /= 10;
        }
        return ans == x;
    }
}
