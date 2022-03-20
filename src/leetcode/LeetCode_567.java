package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/15 23:53
 * @Description:
 */
public class LeetCode_567 {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        int[] windows = new int[26];
        int[] needs = new int[26];
        char[] arrayS1 = s1.toCharArray();
        char[] arrayS2 = s2.toCharArray();
        int left = 0;
        int right = 0;
        int match = 0;
        for (char ch : arrayS1) {
            needs[ch - 'a']++;
        }
        while (right < s2.length()) {
            char ch = arrayS2[right];
            windows[ch - 'a']++;
            if (needs[ch - 'a'] > 0 && needs[ch - 'a'] >= windows[ch - 'a']){
                match++;
            }
            right++;
            while (match == s1.length()){
                char cha = arrayS2[left];
                if (right - left == match){
                    return true;
                }else {
                    if (needs[cha - 'a'] > 0 && needs[cha - 'a'] >= windows[cha - 'a'] ){
                        match--;
                    }
                }
                left++;
                windows[cha - 'a']--;
            }
        }
        return false;
    }
}
