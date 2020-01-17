package leetcode;

import java.util.HashSet;

/**
 * @author 武凯焱
 * @date 2019/10/15 22:19
 * @Description: Leetcode_3
 */
public class Leetcode_3 {
    public static void main(String[] args) {
        System.out.println(slidingWindow("abcabcbb"));

    }

    /**
     * 暴力枚举法
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (check(i, j, s)) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }

    /**
     * 判断每一个子串是否是不重复的
     */
    public static boolean check(int i, int j, String s) {
        HashSet<Character> set = new HashSet<>();
        for (int k = i; k < j; k++) {
            if (set.contains(s.charAt(k))) {
                return false;
            }
            set.add(s.charAt(k));
        }
        return true;
    }
    public static int slidingWindow(String str) {
        HashSet<Character> hashSet = new HashSet<Character>();
        int left = 0, right = 0, res = 0;
        while (left < str.length() && right < str.length()){
            if (!hashSet.contains(str.charAt(right))){
                hashSet.add(str.charAt(right++));
                res = Math.max(res,right - left);
            }else {
                hashSet.remove(str.charAt(left++));
            }
        }
        return res;
    }


}
