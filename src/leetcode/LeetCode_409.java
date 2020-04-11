package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/3/19 22:18
 * @Description:
 */
public class LeetCode_409 {
    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int[] nums = new int[58];
        char[] chars = s.toCharArray();
        for (char ch: chars) {
            nums[ch - 'A'] ++;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - (nums[i] & 1);
        }
        return res < s.length() ? res+1 : res;
    }
}
