package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/24 10:39
 * @Description:
 */
public class LeetCode_5417 {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        int ans = -1;
        int cur = 0;
        while (right < s.length()){
            while (right - left + 1 < k){
                if (jundge(chars[right])){
                    cur++;
                }
                right++;
            }
            if (jundge(chars[right])){
                cur++;
            }
            right++;
            ans = Math.max(ans,cur);
            if (jundge(chars[left])){
                cur--;
            }
            left++;
        }
        return ans;
    }
    public boolean jundge (char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u'){
            return true;
        }
        return false;
    }
}
