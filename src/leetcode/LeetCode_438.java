package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/1/28 21:57
 * @Description:
 */
public class LeetCode_438 {
    public static void main(String[] args) {
        List<Integer> list = new LeetCode_438().findAnagrams5("cbaebabacd", "abc");
        for (Integer integer : list) {
            System.out.print(integer + ", ");
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            int number = pmap.getOrDefault(ch, 0);
            pmap.put(ch, number + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0, r = 0;
        int plength = p.length();
        //候选字符个数
        int count = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if (pmap.containsKey(ch) && pmap.get(ch) >= smap.get(ch)) {
                count++;
            }
            //当候选字符个数等于p长度，此时left为起始索引
            if (count == plength) {
                list.add(l);
            }
            //当窗口大小等于p长度时，窗口左边需要收缩一个字符
            if ((r - l) + 1 >= plength) {
                ch = s.charAt(l);
                if (pmap.containsKey(ch) && pmap.get(ch) >= smap.get(ch)) {
                    count--;
                }
                smap.put(ch, smap.getOrDefault(ch, 1) - 1);
                l++;
            }
            r++;
        }
        return list;

    }

    public List<Integer> findAnagrams1(String s, String p) {
        //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] needs = new int[26];
        int[] window = new int[26];
        for (char ch : p.toCharArray()) {
            int temp = ch - 'a';
            int number = needs[temp];
            needs[temp] = number + 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0, r = 0;
        int plength = p.length();
        //候选字符个数
        int count = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            int temp = ch - 'a';
            window[temp] = window[temp] + 1;
            if (needs[temp] > 0 && needs[temp] >= window[temp]) {
                count++;
            }
            //当候选字符个数等于p长度，此时left为起始索引
            if (count == plength) {
                list.add(l);
            }
            //当窗口大小等于p长度时，窗口左边需要收缩一个字符
            if ((r - l) + 1 >= plength) {
                ch = s.charAt(l);
                temp = ch - 'a';
                if (needs[temp] > 0 && needs[temp] >= window[temp]) {
                    count--;
                }
                window[temp] = window[temp] - 1;
                l++;
            }
            r++;
        }
        return list;
    }

    public List<Integer> findAnagrams5(String s, String p) {
        char[] sarray = s.toCharArray();
        char[] parray = p.toCharArray();
        int[] needs = new int[26];
        int[] windows = new int[26];
        for (int i = 0; i < parray.length; i++) {
            needs[parray[i] - 'a']++;
        }
        LinkedList<Integer> res = new LinkedList();
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < s.length()) {
            char ch = sarray[right];
            windows[ch - 'a']++;
            if (needs[ch - 'a'] > 0 && needs[ch - 'a'] >= windows[ch - 'a']){
                match++;
            }
            right++;
            while (match == parray.length){
                if (right - left == parray.length){
                    res.add(left);
                }
                char cha = sarray[left];
                if (needs[cha - 'a'] > 0 && needs[cha - 'a'] >= windows[cha - 'a']){
                    match--;
                }
                windows[cha - 'a']--;
                left++;
            }
        }
        return res;
    }
}
