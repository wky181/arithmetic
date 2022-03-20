package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/4/12 10:49
 * @Description:
 */
public class LeetCode_5381 {
    public static void main(String[] args) {
        int[] array = {7,5,5,8,3};
        new LeetCode_5381().processQueries(array,8);

    }
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        if (queries.length == 0 || m <= 0){
            return result;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < queries.length ; i++) {
           int index =  queries[i];
            int res = find(deque, index);
            result[i] = res;
        }
        return result;
    }
    public int find(Deque<Integer> integers, int index){
        int mark = 0;
        for (Integer  integer: integers) {
                if (integer == index){
                    break;
                }
                mark++;
        }
        integers.remove(index);
        integers.addFirst(index);
        return mark;
    }
}
