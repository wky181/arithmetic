package leetcode;

import java.util.Arrays;
/**
 * @Author: wky233
 * @Date: 2020/4/2 0:53
 * @Description:
 */
public class LeetCode_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = g.length-1;
        int si = s.length-1;
        int res = 0;
        while (gi >=0 && si>= 0){
            if (g[gi] <= s[si]){
                res++;
                gi--;
                si--;
            }else {
                gi--;
            }
        }
        return res;
    }
}
