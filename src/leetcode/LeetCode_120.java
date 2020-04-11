package leetcode;

import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/3/19 23:37
 * @Description:
 */
public class LeetCode_120 {
    public static void main(String[] args) {

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> list = triangle.get(i + 1);
            List<Integer> l = triangle.get(i);
            for (int j = 0; j < list.size()-1; j++) {
                int min = Math.min(list.get(j), list.get(j + 1));
                l.set(j,min + l.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
