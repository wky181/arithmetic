package LeetCodeSecond.queue;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/20 22:18
 * @Description:
 */
public class LeetCode_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (int task: tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0){
            int i = 0;
            while (i <= n){
                if (map[25] == 0){
                    break;
                }
                if (i < 26 && map[25] > 0){
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}
