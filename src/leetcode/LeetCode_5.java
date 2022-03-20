package leetcode;

/**
 * @author 武凯焱
 * @date 2019/11/23 16:07
 * @Description:
 */
public class LeetCode_5 {
    public static void main(String[] args) {

        System.out.println(new LeetCode_5().longestPalindrome5("bb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        char[] chars = s.toCharArray();
        int[] range = new int[2];
        for (int i = 0; i < s.length(); i++) {
                i = find(chars,range,i);
        }
        return s.substring(range[0],range[1]+1);
    }

    public static int find(char[] chars, int[] range, int high) {
        int low = high;
        //将low和high 的中间看作一个字符
        while (high < chars.length - 1 && chars[high + 1] == chars[low]) {
            high++;
        }
        // 直接跳过 bbbb类似的连续回文字符串 避免重复计算
        int ans = high;
        while (low > 0 && high < chars.length - 1 && chars[low - 1] == chars[high + 1]) {
            high++;
            low--;
        }
        if (high-low > range[1] - range[0]){
            range[1] = high;
            range[0] = low;
        }
        return ans;
    }


    public String longestPalindrome1(String s) {
        if (s == null || s.equals("")) return s;
        char[] schar = s.toCharArray();
        int range[] = new int[2];
        for (int i = 0; i < s.length(); i++) {
            i = findLongest(schar, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public int findLongest(char[] str, int low, int[] range) {
        int high = low;
        // 查找中间部分（定位重复的最后一个字符high，将从low到high的字符看作一个中间字符）
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
    // 中心扩散法
    public String longestPalindrome4(String s) {
        if (s.length() < 2){
            return s;
        }
        String res = s.substring(0,1);
        for (int i = 0; i < s.length()-1; i++) {
            // 奇数长度的中心扩散
            String s1 = getStr(s, i, i);
            //偶数长度的中心扩散
            String s2 = getStr(s, i, i+1);
            String str = s2.length() > s1.length() ? s2 : s1;
            if (str.length() > res.length()){
                res  = str;
            }
        }
        return res;
    }
    public String getStr (String s ,int left, int right){
        char[] arrays = s.toCharArray();
        while (right < arrays.length &&  left >=0){
            if (arrays[left] == arrays[right]){
                right++;
                left--;
            }else {
                break;
            }
        }
        return s.substring(left+1,right);
    }
    // 动态规划写法
    public String longestPalindrome5(String s) {
       if(s.length() < 2){
           return s;
       }
       int maxLen = 1;
       int bgein = 0;
       boolean[][] dp = new boolean[s.length()][s.length()];
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length ; i++) {
            for (int j = i-1; j > 0 ; j--) {
                if (array[i] == array[j]){
                    if (i - j  <= 2){
                        dp[j][i] = true;
                    }else {
                        dp[j][i] = dp[j+1][i-1];
                    }
                }else {
                    dp[j][i] = false;
                }
                if (dp[j][i] && i-j + 1 > maxLen){
                    maxLen = i-j + 1;
                    bgein = j;
                }
            }
        }
        return s.substring(bgein,bgein+maxLen);
    }

}
