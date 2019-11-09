package leetcode;
import	java.util.HashSet;

/**
 * @author 武凯焱
 * @date 2019/10/15 22:19
 * @Description: Leetcode_3
 */
public class Leetcode_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }
    //暴力枚举法
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <=n ; j++) {
                if (check(i,j,s)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
        }
        public static boolean check(int i,int j,String s){
            HashSet<Character> set = new HashSet<> ();
            for (int k = i; k <j ; k++) {
                if (set.contains(s.charAt(k))){
                    return false;
                }
                set.add(s.charAt(k));
            }
            return true;
        }
        public static int slidingWindow(String str){
            HashSet<Character> set = new HashSet<> ();
            int i = 0,j=0,ans=0;
            while (i<str.length() && j < str.length()){
                if (!set.contains(str.charAt(j))){
                    set.add(str.charAt(j++));
                    ans = Math.max(ans, j-i);
                }else {

                    set.remove(str.charAt(i++));
                }
            }
            return ans ;
        }
}
