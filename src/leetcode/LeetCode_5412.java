package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/17 10:33
 * @Description:
 */
public class LeetCode_5412 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count  = 0;
        for (int i = 0; i < startTime.length ; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
}
