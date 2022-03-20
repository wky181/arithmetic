package LeetCodeSecond.dp;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/7/13 0:46
 * @Description:
 */
public class LeetCode_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,((o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else {
                return o2[0] - o1[0];
            }
        }));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
