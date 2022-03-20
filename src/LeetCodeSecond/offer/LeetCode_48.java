package LeetCodeSecond.offer;

import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/6/26 22:58
 * @Description: 滑动窗口
 */
public class LeetCode_48 {
    public static void main(String[] args) {
        String s = " ";
        char[] toCharArray = s.toCharArray();
        System.out.println((int)toCharArray[0] - '0');
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int[] windows = new int[256];
        char[] array = s.toCharArray();
        int res = 1;
        // 滑动窗口模板
        while (right < s.length()){
            char word = array[right++];
            windows[word]++;
            if (windows[word] > 1){
                while (windows[word] > 1){
                    char leftWord = array[left];
                    windows[leftWord]--;
                    left++;
                }
            }else {
                int lenght = right - left;
                res = Math.max(res,lenght);
            }
        }
        return res;
    }
}
