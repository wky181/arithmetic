package LeetCodeSecond.doublepointer;

/**
 * @Author: wky233
 * @Date: 2020/9/16 23:49
 * @Description:
 */
public class LeetCode845 {
    public int longestMountain(int[] A) {
       if (A == null || A.length == 0){
           return 0;
       }
       int max = 0;
        for (int i = 0; i < A.length - 2 ;) {
            if (A[i+1] <= A[i]){
                i++;
                continue;
            }
            boolean mark = false;
            int j = i + 1;
            // 上山
            while (j + 1 < A.length && A[j + 1] > A[j] ){
                j++;
            }
            while (j + 1 < A.length && A[j + 1] < A[j]){
                mark = true;
                j++;
            }
            if (mark){
                max = Math.max(j - i, max);

            }
            i  = j;
        }
        return max;
    }
}
