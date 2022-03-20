package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/5/21 9:28
 * @Description:
 */
public class LeetCode_1371 {
    // 异或前缀和
    public int findTheLongestSubstring(String s) {
        int cur = 0;
        int ans = 0;
        char[] array = s.toCharArray();
        int[] pre = new int[32];
        Arrays.fill(pre, -2);
        // 考虑符合条件的数组没有一个元音字母的情况。
        pre[0] = -1;
        for (int i = 0; i < array.length; i++) {
            switch (pre[i]) {
                case 'a':
                    cur ^= 1;
                    break;
                case 'e':
                    cur ^= 2;
                    break;
                case 'i':
                    cur ^= 4;
                    break;
                case 'o':
                    cur ^= 8;
                    break;
                case 'u':
                    cur ^= 16;
                    break;
                default:
                    break;
            }
            if (pre[cur] == -2){
                pre[cur] = i;
            }else {
                ans = Math.max(ans,i - pre[cur]);
            }
        }
        return ans;
    }

}
