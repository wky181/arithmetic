package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/1/30 20:06
 * @Description:
 */
public class LeetCode_205 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_205().isIsomorphic("egg","add"));
    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        //字符键值对匹配
        char[] match = new char[128];
        //统计出现并匹配过的字符
        int[] appear = new int[128];
        char[] chars = t.toCharArray();
        for (int i = 0; i < s.length() ; i++) {
            char charss = s.charAt(i);
            char charMatch = match[charss];
            if (charMatch == 0 && appear[chars[i]] > 0){
                return false;
            }
            else if (charMatch == 0 ){
                appear[chars[i]]++;
                match[charss] = chars[i];
            }else {
                if (charMatch != chars[i]){
                    return false;
                }
            }

        }
        return true;
    }
}
