package leetcode;

import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/5/30 22:42
 * @Description:
 */
public class LeetCode_5049 {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("0110",2));
    }
    public static boolean hasAllCodes(String s, int k) {
        int left = 0;
        int right = k-1;
        HashSet<String> set = new HashSet<>();
        while (k < s.length()){
            set.add(s.substring(left,right));
            left++;
            right++;
        }
        int num = (int) Math.pow(2,k);
        return set.size() == num;

    }
}
