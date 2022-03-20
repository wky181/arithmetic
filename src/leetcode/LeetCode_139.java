package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/3/30 0:29
 * @Description:
 */
public class LeetCode_139 {
    public static void main(String[] args) {

    }

    //参考leetcode题解
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        int[] vist = new int[s.length() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer start = queue.poll();
            if (vist[start] == 0) {
                for (int i = start + 1; i <= s.length(); i++) {
                    if (set.contains(s.substring(start, i))) {
                        if (i == s.length()) {
                            return true;
                        }
                        queue.offer(i);
                        vist[start] = 1;
                    }
                }
            }
        }
        return vist[s.length()] == 1;
    }
    HashMap<Integer,Boolean> hashMap = new HashMap<>();
    /**
     * 暴力解法,从开头一点一点截取字符串，然后判断是否在字典序中是否存在
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (String str: wordDict) {
            set.add(str);
            max = Math.max(max, str.length());
        }
        return recursive(s,0,max,set);
    }

    public boolean recursive(String s, int start,int max, HashSet<String> hashSet) {
        if (start == s.length()){
            return true;
        }
        if (hashMap.containsKey(start) ){
            return hashMap.get(start);
        }
        for (int i = start; i < start+max && i < s.length() ; i++) {
            if (hashSet.contains(s.substring(start, i + 1))) {
               if (recursive(s, i + 1,max, hashSet )){
                   hashMap.put(start,true);
                    return true;
               }
            }
        }
        hashMap.put(start,false);
        return false;
    }

}
