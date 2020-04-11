package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/3/10 11:03
 * @Description:
 */
public class LeetCode_1552 {
    public static void main(String[] args) {
        new LeetCode_1552().findContinuousSequence(15);
    }

    public int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return null;
        }
        int l = 1;
        int r = 2;
        int res = l;
        List<List> lists = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(l);
        while (l < r) {
            if (res == target) {
                if (list.size() > 1) {
                    lists.add(Arrays.asList(list.toArray()));
                }
                res -= list.poll();
                l++;
            } else if (res < target) {
                list.offer(r);
                res += r;
                r++;
            } else {
                res -= list.poll();
                l++;
            }

        }
        System.out.println(lists);
        return null;
    }
}
