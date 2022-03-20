package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/4/21 22:52
 * @Description:
 */
public class LeetCode_1248 {
    public static void main(String[] args) {
        System.out.println(23 & 1);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int[] preNum = new int[nums.length + 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preNum[i + 1] = preNum[i];
            if ((nums[i] & 1) == 1) {
                preNum[i + 1] += 1;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preNum[i] - preNum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        //统计每个前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] & 1;
            // 算出要找的前缀和
            int num_j = sum - k;
            if (map.containsKey(num_j)) {
                count += map.get(num_j);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
       /* for (int i = 1; i <= nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (preNum[i] - preNum[j] == k){
                    count++;
                }
            }
        }*/
        return count;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int windowsCount = 0;
        while (right < nums.length) {
            windowsCount += nums[right] & 1;
                while (windowsCount > k){
                    if ((nums[left] & 1) == 1){
                        windowsCount--;
                    }
                    left++;
                }
                if (windowsCount == k){
                    ans++;
                }
            right++;
        }
        return ans;
    }

}
