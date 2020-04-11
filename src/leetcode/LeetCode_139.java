package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        for (String str: wordDict) {
            set.add(str);
        }
        int[] vist = new int[s.length()+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
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
}
