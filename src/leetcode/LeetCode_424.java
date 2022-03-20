package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/15 17:12
 * @Description:
 */
public class LeetCode_424 {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] windows = new int[26];
        int maxCount = 0;
        int res = 0;
        char[] array = s.toCharArray();
        while (right < s.length()){
            windows[array[right ] - 'A']++;
            // 记录窗口中出现次数最多的字符
            maxCount = Math.max(windows[array[right] - 'A'], maxCount);
            right++;
            while (right - left > maxCount + k){
                //只要没有出现更大的maxCount, 就不会有更长的重复子串; 因此left向后移动时不需要更新maxCount的值
                windows[array[left] - 'A']--;
                left++;
            }
            res = Math.max(res,right  - left);
        }
        return res;
    }
}
