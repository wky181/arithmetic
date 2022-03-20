package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/18 22:49
 * @Description:
 */
public class LeetCode_5373 {
    public int findMinFibonacciNumbers(int k) {
        if (k <= 2){
            return 1;
        }
        int pre_p = 1;
        int pre = 1;
        int cur = pre + pre_p;
        while (cur < k){
            pre_p = pre;
            pre = cur;
            cur = pre + pre_p;
            if (cur == k){
                return 1;
            }
        }
        return findMinFibonacciNumbers(k - pre)+1;
    }
}
