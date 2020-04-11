package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/3 23:26
 * @Description:
 */
public class LeetCode_10_10 {
    public void merge(int[] A, int m, int[] B, int n) {
        int a = m-1;
        int b = n-1;
        int last = A.length-1;
        while (a >= 0 && b >= 0){
            if (A[a] > A[b]){
                A[last--] = A[a--];
            }else {
                A[last--] = A[b--];
            }
        }
        if (a < 0){
            while (b >= 0){
                A[last--] = A[b--];
            }
        }else {
            while (a >= 0){
                A[last--] = A[a--];
            }
        }
    }
}
