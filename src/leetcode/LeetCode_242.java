package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/1/30 15:37
 * @Description:
 */
public class LeetCode_242 {
    public static void main(String[] args) {
       boolean d  = new LeetCode_242().isAnagram1("nl","cx");
        System.out.println(d);
    }
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length() ; i++) {
            int temp = t.charAt(i) - 'a';
            if (nums[temp] > 0){
                nums[temp] =  nums[temp] - 1 ;
            }else{
        return false;
        }
        }
        return true;
        }
    /**
     * 优化思路
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] += 1;
            nums[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0){
                return false;
            }
        }
        return true;
    }
}
