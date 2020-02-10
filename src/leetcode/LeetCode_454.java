package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/2/4 20:59
 * @Description:
 */
public class LeetCode_454 {

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        int res = new LeetCode_454().fourSumCount(A,B,C,D);
        System.out.println(res);
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (!(A.length == B.length  && A.length == C.length && A.length == D.length)){
            return 0;
        }
        HashMap<Integer,Integer> hashMapCD = new HashMap<>();
        for (int i = 0; i < C.length ; i++) {
            for (int j = 0; j < D.length ; j++) {
                int value = C[i]+D[j];
                hashMapCD.put(value,hashMapCD.getOrDefault(value,0)+1);
            }

        }
        int res = 0;
        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < B.length ; j++) {
                int value = -A[i] - B[j];
                res += hashMapCD.getOrDefault(value,0);
            }

        }
        return res;
    }
}
