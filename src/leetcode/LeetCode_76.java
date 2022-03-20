package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/1/29 16:52
 * @Description:
 */
public class LeetCode_76 {
    public static void main(String[] args) {
       String string =  new LeetCode_76().minWindowAgain("aaflslflsldkalskaaa","aaa");
        System.out.println(string);

    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        int l = 0, r = 0;
        int plength = t.length();
        //候选字符数
        int count = 0;
        int minLength = s.length() + 1;
        String result = "";
        while (r < s.length()) {
            char ch = s.charAt(r);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if (pmap.containsKey(ch) && pmap.getOrDefault(ch, 0) >= smap.get(ch)) {
                count++;
            }
            while (count == plength) {
                ch = s.charAt(l);
                if (pmap.containsKey(ch) && pmap.get(ch) >= smap.get(ch)) {
                    count--;
                }
                if ((r - l) - 1 < minLength) {
                    minLength = (r - l) - 1;
                    result = s.substring(l, r + 1);
                }
                smap.put(ch, smap.getOrDefault(ch, 1) - 1);
                l++;
            }
            r++;
        }
        return result;
    }

    public String minWindow1(String s, String t) {
        //由于字符类型，就考虑所有的ASCII码，因此直接用128个长度的数组代替原来的HashMap,提高性能
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];
        //统计t中每个字符出现次数
        for (char ch : t.toCharArray()) {
            needs[ch] = needs[ch] + 1;
        }
        int l = 0, r = 0;
        int plength = t.length();
        //候选字符数
        int count = 0;

        int minLength = s.length() + 1;
        String result = "";
        while (r < s.length()) {
            char ch = s.charAt(r);
            //统计滑动窗口中每个字符出现次数
            window[ch] = window[ch] + 1;
            // 当这个字符是在t中，并且t需要的次数大于等于该字符在滑动窗口出现的次数，被确定为候选字符。
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }
            //当候选字符数等于t的长度时，说明滑动窗口中的字符串包含T，开始移动l，缩小窗口
            //直到不满足count == plength时，继续扩展窗口
            while (count == plength) {
                ch = s.charAt(l);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if ((r - l) + 1 < minLength) {
                    minLength = (r - l) + 1;
                    result = s.substring(l, r + 1);
                }
                window[ch] = window[ch] - 1;
                l++;
            }
            r++;
        }
        return result;
    }

    public String minWindowAgain(String s, String t) {
        int[] needs = new int[123];
        int[] windows = new int[123];
        char[] tArrays = t.toCharArray();
        char[] sArrays = s.toCharArray();
        //需要匹配字母种类个数
        int mark = t.length();
        for (int i = 0; i < tArrays.length ; i++) {
            if (needs[tArrays[i]] >= 1){
                mark--;
            }
            needs[tArrays[i]]++;
        }
        int left = 0;
        int right = 0;
        int minLength = s.length() + 1;
        String res = "";
        // 记录windows中已经有多少字符符合要求了。
        int match = 0;
        while (right < s.length()) {
            char ch = sArrays[right];
            windows[ch]++;
            // 如果新添加的字符是needs需要的字符，并且刚好次数刚好想等，match+=1;
            if (needs[ch] > 0 && windows[ch] == needs[ch]){
                match++;
            }
            right++;
            while (match == mark){
                char cha = sArrays[left];
                if ((right - left) < minLength){
                    minLength = right - left ;
                    res = s.substring(left, right);
                }
                if (needs[cha] > 0 && needs[cha] >= windows[cha]){
                    match--;
                }
                windows[cha]--;
                left++;
            }
        }
        return res;
    }

}
