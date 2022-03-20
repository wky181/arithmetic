package LeetCodeSecond.offer2;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/9/18 15:29
 * @Description:
 */
public class offer48 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int[] windows  = new int[256];
        int max = 0;
        while (r < s.length()){
            char word = s.charAt(r);
            windows[word]++;
            if (windows[word] > 1){
                while (windows[word] > 1){
                    char leftWord  = s.charAt(l);
                    windows[leftWord]--;
                    l++;
                }
            }else {
                int length = r - l + 1;
                max = Math.max(max, length);
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        HashSet<Character> windows = new HashSet<>();
        while (r < s.length()){
            char word = s.charAt(r);
            r++;
            if (windows.contains(word)){
                while (windows.contains(word)){
                    char leftWord = s.charAt(l);
                    windows.remove(leftWord);
                    l++;
                }
            }else {
                int length = r - l;
                max = Math.max(length,max);
            }
            windows.add(word);
        }
        return max;
    }
}
