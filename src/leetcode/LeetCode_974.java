package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/5/27 23:22
 * @Description:
 */
public class LeetCode_974 {
    public static void main(String[] args) {

    }

    public int subarraysDivByK(int[] A, int K) {
        int[] perSums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            perSums[i + 1] = perSums[i] + A[i];
        }
        int ans = 0;
        for (int i = 1; i < perSums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (perSums[i] - perSums[j] % K == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int subarraysDivByK1(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < A.length ; i++) {
            sum += A[i];
            int modulus  = (sum % K + K) % K;
            int same = record.getOrDefault(modulus,0);
            ans += same;
            record.put(modulus,same+1);
        }
        return ans;
    }
    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        //如果元素自己余数也为零
        record.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < A.length ; i++) {
            sum += A[i];
            // 防止sum为负数导致取余为负数
            int yu = (sum & K + K) % K;
            int same = record.getOrDefault(yu,0);
            ans += same;
            record.put(yu,same+1);
        }
        return ans;
    }
}
