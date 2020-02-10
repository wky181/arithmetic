package leetcode;

import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/1/30 16:12
 * @Description:
 */
public class LeetCode_202 {
    /**
     * 利用hsah来做
     */
    public boolean isHappy(int n) {
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
    public  int powNum(int m){
        int num = 0;
        while (m != 0) {
            num += (int) Math.pow(m % 10, 2);
            m /= 10;
        }
        return num;
    }
    /**
     * 利用快慢指针来做
     */
    public boolean isHappy1(int n) {
        int slow = n; int fast = n;
        do {
            slow = powNum(slow);
            fast = powNum(fast);
            fast = powNum(fast);
        }while (slow != fast);
        return slow == 1;
    }

}
